package di

import PlatformConfiguration
import org.koin.dsl.module

object InitSdk {
    fun init(configuration: PlatformConfiguration) {
        val initModule = module {
            single {
                configuration
            }
            single {

            }
        }

        initKoin(
            initModule,
            employeesModule,
        )
    }
}
