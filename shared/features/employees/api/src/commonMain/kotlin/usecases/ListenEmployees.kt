package usecases

import kotlinx.coroutines.flow.Flow
import models.Employee
import repositories.EmployeeRepository

class ListenEmployees(
    private val employeeRepository: EmployeeRepository
) {

    operator fun invoke(): Flow<List<Employee>> = employeeRepository.listenEmployees()
}