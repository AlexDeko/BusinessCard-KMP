package storages

import card.business.EmployeeEntity
import kotlinx.coroutines.flow.Flow

interface EmployeesStorage {

    fun saveEmployeeEntity(employeeEntity: EmployeeEntity)

    fun listenEmployees(): Flow<List<EmployeeEntity>>
}