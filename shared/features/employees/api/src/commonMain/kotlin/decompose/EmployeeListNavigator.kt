package decompose

import models.Employee

interface EmployeeListNavigator : Navigator<EmployeeListNavigator.Child> {
    sealed class Child {

        object EmployeesListChild : Child()

        class DetailsEmployeeChild(val employee: Employee) : Child()
    }
}