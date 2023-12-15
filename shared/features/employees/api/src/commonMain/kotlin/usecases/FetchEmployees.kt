package usecases

import repositories.EmployeeRepository

class FetchEmployees(
    private val employeeRepository: EmployeeRepository
) {

    suspend operator fun invoke() = employeeRepository.fetchEmployees()
}