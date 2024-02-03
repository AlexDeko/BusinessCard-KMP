package employees.models

import models.Employee

data class EmployeesDataState(
    val employees: List<Employee> = listOf()
)