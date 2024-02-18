package employees.models

import models.Employee

sealed class EmployeesEvent {
    data class ClickEmployees(
        val employee: Employee
    ) : EmployeesEvent()
    data object Back : EmployeesEvent()
}
