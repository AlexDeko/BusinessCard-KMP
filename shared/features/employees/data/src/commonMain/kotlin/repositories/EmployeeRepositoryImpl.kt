package repositories

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import mapping.mapToEmployee
import mapping.mapToEmployeeEntity
import models.Employee
import network.EmployeesApi
import storages.EmployeesStorage

class EmployeeRepositoryImpl(
    private val ktorApi: EmployeesApi,
    private val db: EmployeesStorage
) : EmployeeRepository {

    override fun listenEmployees(): Flow<List<Employee>> =
        db.listenEmployees().map { employees ->
            employees.map { employee ->
                employee.mapToEmployee()
            }
        }

    override suspend fun fetchEmployees() {
        ktorApi.fetchEmployees().map {
            db.saveEmployeeEntity(it.mapToEmployeeEntity())
        }
    }
}