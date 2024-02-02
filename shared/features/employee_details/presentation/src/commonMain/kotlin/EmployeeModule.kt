package employee

import coroutines.Dispatchers
import dev.icerock.moko.mvvm.compose.viewModelFactory
import ktor.EmployeesKtorApi
import network.EmployeesApi
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val employeeModule = module {

    singleOf(::EmployeesKtorApi) { bind<EmployeesApi>() }

    single {
        viewModelFactory {
            EmployeeListViewModel(
                dispatchers = Dispatchers,
                listenEmployees = get(),
                fetchEmployees = get()
            )
        }.createViewModel()
    }
}