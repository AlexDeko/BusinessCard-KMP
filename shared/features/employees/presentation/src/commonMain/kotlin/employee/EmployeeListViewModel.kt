package employee

import coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import employee.models.EmployeeAction
import employee.models.EmployeeEvent
import models.Employee
import usecases.FetchEmployees
import usecases.ListenEmployees
import view_model.BaseViewModel
import view_model.State


class EmployeeListViewModel(
    private val dispatchers: Dispatchers,
    private val listenEmployees: ListenEmployees,
    private val fetchEmployees: FetchEmployees
) : BaseViewModel<State<List<Employee>>, EmployeeAction, EmployeeEvent>(
    initialState = State.Loading
) {

    init {
        viewModelScope.launch {
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
                            data = employees
                        )
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
}