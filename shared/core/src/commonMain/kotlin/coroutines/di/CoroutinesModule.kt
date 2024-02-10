package coroutines.di

import coroutines.Dispatchers
import coroutines.coroutineScope
import org.koin.dsl.module

val coroutinesModule = module {
    single {
        coroutineScope
    }
    single {
        Dispatchers
    }
}