package employees

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.router.stack.StackNavigation
import com.arkivanov.decompose.router.stack.childStack
import com.arkivanov.decompose.router.stack.push
import com.arkivanov.decompose.value.Value
import coroutines.Dispatchers
import decompose.EmployeeListNavigator
import decompose.MviComponent
import decompose.State
import employees.models.EmployeesDataState
import employees.models.EmployeesEvent
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import kotlinx.serialization.Serializable
import models.Employee
import org.koin.core.component.inject
import usecases.FetchEmployees
import usecases.ListenEmployees


class DefaultEmployeeListComponent(
    private val componentContext: ComponentContext,
) : MviComponent<EmployeesDataState, EmployeesEvent>(
    initialState = State.Loading,
    componentContext = componentContext
), EmployeeListNavigator {

    private val listenEmployees: ListenEmployees by inject()
    private val dispatchers: Dispatchers by inject()
    private val fetchEmployees: FetchEmployees by inject()

    private val navigation = StackNavigation<EmployeeListConfig>()

    private val _childStackNavigation = childStack(
        source = navigation,
        initialConfiguration = EmployeeListConfig.EmployeesList,
        serializer = EmployeeListConfig.serializer(),
        handleBackButton = true,
        childFactory = ::createChild,
        key = "listEmployeesStack",
    )

    override val childStackNavigation: Value<ChildStack<*, EmployeeListNavigator.Child>> =
        _childStackNavigation

    private fun createChild(
        config: EmployeeListConfig,
        componentContext: ComponentContext
    ): EmployeeListNavigator.Child =
        when (config) {
            is EmployeeListConfig.EmployeesList -> EmployeeListNavigator.Child.EmployeesListChild

            is EmployeeListConfig.EmployeesDetail -> EmployeeListNavigator.Child.DetailsEmployeeChild(
                employee = config.employee
            )
        }

    init {
        componentScope.launch {
            withContext(dispatchers.IO) {
                fetchEmployees()
            }

            listenEmployees()
                .flowOn(dispatchers.IO)
                .catch {
                    pushState(State.Error(it))
                }
                .collect { employees ->
                    pushState(
                        State.Success(
                            data = EmployeesDataState(employees)
                        )
                    )
                }
        }
    }

    override fun obtainEvent(event: EmployeesEvent) {
        when (event) {
            is EmployeesEvent.ClickEmployees -> navigation.push(
                EmployeeListConfig.EmployeesDetail(
                    employee = event.employee
                )
            )
        }
    }
}

@Serializable
private sealed class EmployeeListConfig {
    @Serializable
    data object EmployeesList : EmployeeListConfig()

    @Serializable
    data class EmployeesDetail(val employee: Employee) : EmployeeListConfig()
}