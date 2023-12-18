import coroutines.Dispatchers
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import models.Employee
import models.EmployeeAction
import models.EmployeeEvent
import models.EmployeeState
import usecases.FetchEmployees
import usecases.ListenEmployees
import view_model.BaseViewModel

class EmployeesViewModel(
    private val dispatchers: Dispatchers,
    private val listenEmployees: ListenEmployees,
    private val fetchEmployees: FetchEmployees,
) : BaseViewModel<EmployeeState, EmployeeAction, EmployeeEvent>(
    initialState = EmployeeState()
) {

    init {
        viewModelScope.launch {
            withContext(dispatchers.IO) {
                fetchEmployees()
            }

            listenEmployees()
                .flowOn(dispatchers.IO)
                .collect { employees ->
                    setEmployees(
                        employees = employees,
                    )
                }

        }
    }

    override fun obtainEvent(event: EmployeeEvent) {
        when (event) {
            is EmployeeEvent.ClickEmployee -> pushAction(
                EmployeeAction.ShowMessage(
                    employeeId = event.employeeId
                )
            )
        }
    }

    private fun setEmployees(employees: List<Employee>) {
        pushState(
            currentState.copy(
                employees = employees
            )
        )
    }
}