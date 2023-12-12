package sqldelight

import app.cash.sqldelight.coroutines.asFlow
import app.cash.sqldelight.coroutines.mapToList
import card.business.Database
import card.business.EmployeeEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.flow.Flow
import storages.EmployeesStorage

class EmployeesSqlDelightStorage(private val db: Database) : EmployeesStorage {
    override fun saveEmployeeEntity(employeeEntity: EmployeeEntity) {
        db.employeeQueries.saveEmployee(employeeEntity)
    }

    override fun listenEmployees(): Flow<List<EmployeeEntity>> {
        return db.employeeQueries.getAll().asFlow().mapToList(Dispatchers.IO)
    }
}