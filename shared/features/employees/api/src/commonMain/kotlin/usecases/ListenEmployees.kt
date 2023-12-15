package usecases

import repositories.EmployeeRepository

class ListenEmployees(
    private val employeeRepository: EmployeeRepository
) {

    operator fun invoke() = employeeRepository.listenEmployees()
}