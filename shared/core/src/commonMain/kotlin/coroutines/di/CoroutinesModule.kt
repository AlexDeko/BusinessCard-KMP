package coroutines.di

import coroutines.Dispatchers
import coroutines.coroutineScope
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val coroutinesModule = module {
    single {
        coroutineScope
    }
    singleOf(Dispatchers::IO)
    singleOf(Dispatchers::Default)
    singleOf(Dispatchers::Main)
}