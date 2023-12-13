package database

import DATABASE_NAME
import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.native.NativeSqliteDriver
import card.business.Database

actual class DriverFactory {

    actual fun createDriver(): SqlDriver {
        return NativeSqliteDriver(Database.Schema, DATABASE_NAME)
    }
}