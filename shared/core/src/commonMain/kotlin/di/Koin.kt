package di

import coreModule
import org.koin.core.KoinApplication
import org.koin.core.context.startKoin
import org.koin.core.module.Module

fun initKoin(vararg exportedModules: Module): KoinApplication = startKoin {
    modules(
        *exportedModules,
        coreModule
    )
}