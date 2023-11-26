package com.card.business.data.repositories

import com.card.business.data.api.Api
import com.card.business.data.database.Storage
import com.card.business.domain.interfaces.EmployeeRepository
import com.card.business.domain.models.Employee
import com.card.business.mapToEmployee
import com.card.business.mapToEmployeeEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class EmployeeRepositoryImpl(private val ktorApi: Api, private val db: Storage) :
    EmployeeRepository {
    override fun listenEmployees(): Flow<List<Employee>> {
        return db.listenEmployees().map { employees ->
            employees.map { employee ->
                employee.mapToEmployee()
            }
        }
    }

    override suspend fun fetchEmployees() {
        ktorApi.fetchEmployees().map {
            db.saveEmployeeEntity(it.mapToEmployeeEntity())
        }
    }

}