package database

import DATABASE_NAME
import PlatformConfiguration
import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.android.AndroidSqliteDriver
import card.business.Database

actual class DriverFactory(
    private val platformConfiguration: PlatformConfiguration
) {

    actual fun createDriver(): SqlDriver = AndroidSqliteDriver(
        Database.Schema,
        platformConfiguration.androidContext,
        DATABASE_NAME
    )
}