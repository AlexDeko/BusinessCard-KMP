package employee

import employee.models.EmployeeAction
import employee.models.EmployeeEvent
import models.Employee
import view_model.BaseViewModel
import view_model.State

class EmployeeDetailedViewModel: BaseViewModel<State<Employee>, EmployeeAction, EmployeeEvent>(initialState = State.Loading) {
    override fun obtainEvent(event: EmployeeEvent) {

    }

}