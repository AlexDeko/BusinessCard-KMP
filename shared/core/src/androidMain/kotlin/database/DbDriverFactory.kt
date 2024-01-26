package database

import DATABASE_NAME
import PlatformConfiguration
import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.android.AndroidSqliteDriver
import card.business.Database
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

actual class DriverFactory : KoinComponent {

    private val platformConfiguration: PlatformConfiguration by inject()

    actual fun createDriver(): SqlDriver = AndroidSqliteDriver(
        Database.Schema,
        platformConfiguration.androidContext,
        DATABASE_NAME
    )
}