package employee.models

import models.Employee

data class EmployeeState(
    val employees: List<Employee> = listOf()
)