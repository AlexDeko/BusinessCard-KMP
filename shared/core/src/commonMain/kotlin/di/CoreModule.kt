package di

import coroutines.di.coroutinesModule
import database.di.databaseModule
import json.serializationModule
import ktor.di.ktorModule
import org.koin.dsl.module

val coreModule = module {
    includes(
        serializationModule,
        coroutinesModule,
        ktorModule,
        databaseModule
    )
}