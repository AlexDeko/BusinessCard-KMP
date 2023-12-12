package network

import dto.EmployeeDto

interface EmployeesApi {

    suspend fun fetchEmployees(): List<EmployeeDto>
}