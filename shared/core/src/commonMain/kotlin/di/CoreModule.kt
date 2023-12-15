import coroutines.di.coroutinesModule
import json.serializationModule
import ktor.di.ktorModule
import org.koin.dsl.module

val coreModule = module {
    includes(
        serializationModule,
        coroutinesModule,
        ktorModule
    )
}