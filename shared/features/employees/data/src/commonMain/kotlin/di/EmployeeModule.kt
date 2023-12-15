package di

import ktor.EmployeesKtorApi
import network.EmployeesApi
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module
import repositories.EmployeeRepository
import repositories.EmployeeRepositoryImpl
import sqldelight.EmployeesSqlDelightStorage
import storages.EmployeesStorage
import usecases.FetchEmployees
import usecases.ListenEmployees

val employeesModule = module {
    singleOf(::EmployeesKtorApi) { bind<EmployeesApi>() }

    singleOf(::EmployeesSqlDelightStorage) { bind<EmployeesStorage>() }

    singleOf(::EmployeeRepositoryImpl) { bind<EmployeeRepository>() }

    singleOf(::FetchEmployees)

    singleOf(::ListenEmployees)
}