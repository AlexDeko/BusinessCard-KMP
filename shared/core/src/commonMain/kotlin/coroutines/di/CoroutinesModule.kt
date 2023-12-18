package coroutines.di

import coroutines.Dispatchers
import coroutines.defaultCoroutineScope
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val coroutinesModule = module {
    single {
        defaultCoroutineScope
    }
    singleOf(Dispatchers::IO)
    singleOf(Dispatchers::Default)
    singleOf(Dispatchers::Main)
}