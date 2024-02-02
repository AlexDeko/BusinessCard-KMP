package employee

import decompose.BaseComponent
import employee.models.EmployeesAction
import employee.models.EmployeesEvent
import models.Employee
import view_model.State

class DefaultEmployeeDetailsComponent :
    BaseComponent<State<Employee>, EmployeesAction, EmployeesEvent>(initialState = State.Loading) {
    override fun obtainEvent(event: EmployeesEvent) {

    }

}