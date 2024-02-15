package database

import app.cash.sqldelight.db.SqlDriver
import card.business.Database

expect class DriverFactory() {
    fun createDriver(): SqlDriver
}

fun createDatabase(driverFactory: DriverFactory): Database = Database(
    driver = driverFactory.createDriver()
)