package coroutines.di

import coroutines.Dispatchers
import coroutines.defaultCoroutineScope
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val coroutinesModule = module {
    factory {
        defaultCoroutineScope
    }
    single {
        Dispatchers
    }
}