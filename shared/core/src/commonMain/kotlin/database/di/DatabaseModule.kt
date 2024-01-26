package database.di

import card.business.Database
import database.DriverFactory
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val databaseModule = module {
    singleOf(DriverFactory::createDriver)
    singleOf(::DriverFactory)
    single {
        Database(driver = get())
    }
}