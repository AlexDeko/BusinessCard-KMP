package com.card.business.data.database

import app.cash.sqldelight.coroutines.asFlow
import app.cash.sqldelight.coroutines.mapToList
import card.business.Database
import card.business.EmployeeEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.flow.Flow

class SqlDelightStorage(private val db: Database) : Storage {
    override fun saveEmployeeEntity(employeeEntity: EmployeeEntity) {
        db.employeeQueries.saveEmployee(employeeEntity)
    }

    override fun listenEmployees(): Flow<List<EmployeeEntity>> {
        return db.employeeQueries.getAll().asFlow().mapToList(Dispatchers.IO)
    }
}