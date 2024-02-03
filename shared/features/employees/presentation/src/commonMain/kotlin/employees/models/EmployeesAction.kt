package employees.models

import models.Employee

sealed class EmployeesAction {
    data class ShowDetails(
        val employee: Employee
    ) : EmployeesAction()
}
