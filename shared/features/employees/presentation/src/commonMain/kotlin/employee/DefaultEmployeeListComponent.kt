package employee

import com.arkivanov.decompose.ComponentContext
import coroutines.Dispatchers
import decompose.BaseComponent
import decompose.State
import employee.models.EmployeesAction
import employee.models.EmployeesDataState
import employee.models.EmployeesEvent
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.koin.core.component.inject
import usecases.FetchEmployees
import usecases.ListenEmployees


class DefaultEmployeeListComponent(
    private val dispatchers: Dispatchers,

    private val fetchEmployees: FetchEmployees,
    private val componentContext: ComponentContext,
) : BaseComponent<EmployeesDataState, EmployeesAction, EmployeesEvent>(
    initialState = State.Loading,
    componentContext = componentContext
) {
    private val listenEmployees: ListenEmployees by inject()

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
            is EmployeesEvent.ClickEmployees -> pushAction(
                EmployeesAction.ShowDetails(
                    employee = event.employee
                )
            )
        }
    }
}