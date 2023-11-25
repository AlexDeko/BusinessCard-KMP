package com.card.business.data.database

import card.business.EmployeeEntity
import com.card.business.domain.models.Employee
import kotlinx.coroutines.flow.Flow

interface Storage {

    fun saveEmployeeEntity(employeeEntity: EmployeeEntity)
    fun listenEmployees(): Flow<List<EmployeeEntity>>
}