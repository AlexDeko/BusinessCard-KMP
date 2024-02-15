package network

import dto.EmployeeDto
import dto.EmployeeDtoWrapper

interface EmployeesApi {

    suspend fun fetchEmployees(): EmployeeDtoWrapper
}