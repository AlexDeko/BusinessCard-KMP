package com.card.business.domain.interfaces

import com.card.business.domain.models.Employee
import kotlinx.coroutines.flow.Flow

interface EmployeeRepository {

    fun listenEmployees(): Flow<List<Employee>>

    suspend fun fetchEmployees()

}