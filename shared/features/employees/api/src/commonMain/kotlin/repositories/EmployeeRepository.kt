package repositories

import kotlinx.coroutines.flow.Flow
import models.Employee

interface EmployeeRepository {

    fun listenEmployees(): Flow<List<Employee>>

    suspend fun fetchEmployees()
}