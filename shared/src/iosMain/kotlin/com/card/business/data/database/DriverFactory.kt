package com.card.business.data.database

import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.native.NativeSqliteDriver
import card.business.Database

actual class DriverFactory {

    actual fun createDriver(): SqlDriver {
        return NativeSqliteDriver(Database.Schema, "renta_database.db")
    }
}