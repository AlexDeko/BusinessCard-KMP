package employee

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import com.arkivanov.decompose.extensions.compose.jetbrains.stack.animation.fade
import com.arkivanov.decompose.extensions.compose.jetbrains.stack.animation.plus
import com.arkivanov.decompose.extensions.compose.jetbrains.stack.animation.scale
import com.arkivanov.decompose.extensions.compose.jetbrains.stack.animation.stackAnimation
import com.arkivanov.decompose.router.stack.StackNavigation
import com.arkivanov.decompose.router.stack.push
import employee.models.EmployeesAction
import employee.models.EmployeesEvent
import employee.models.EmployeesDataState
import extensions.observeAsState
import models.Employee
import navigator.ChildStack
import org.koin.compose.koinInject
import decompose.State

@Composable
fun EmployeeListScreen(
    viewModel: EmployeeListViewModel = koinInject()
) {
    val navigation = remember { StackNavigation<TargetScreen>() }
    val state = viewModel.states.observeAsState()
    val action = viewModel.actions.observeAsState()

    ChildStack(
        source = navigation,
        initialStack = {
            listOf(
                TargetScreen.Employees(
                    state = viewModel.initialState,
                    eventHandler = viewModel::obtainEvent
                )
            )
        },
        animation = stackAnimation(fade() + scale()),
        handleBackButton = true
    ) { screen ->
        when (screen) {
            is TargetScreen.Employees -> EmployeesView(
                state = state.value,
                eventHandler = viewModel::obtainEvent
            )

            is TargetScreen.EmployeesDetailed -> EmployeeDetailedView(employee = screen.employee)
        }
    }

    when (val value = action.value) {
        is EmployeesAction.ShowDetails -> navigation.push(
            TargetScreen.EmployeesDetailed(
                employee = value.employee
            )
        )

        else -> {}
    }
}

sealed class TargetScreen {

    data class Employees(
        val state: State<EmployeesDataState>,
        val eventHandler: (EmployeesEvent) -> Unit
    ) : TargetScreen()

    data class EmployeesDetailed(val employee: Employee) : TargetScreen()
}