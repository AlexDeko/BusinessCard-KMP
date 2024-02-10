package employees.models

import models.Employee

sealed class EmployeesNavigationTarget {
    data class ShowDetails(
        val employee: Employee
    ) : EmployeesNavigationTarget()
}
