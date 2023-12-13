plugins {
    id("kotlin.multiplatform")
}

kotlin {

    sourceSets {
        commonMain {
            dependencies {
                implementation(project(":shared:features:employees:api"))
                implementation(project(":shared:core"))

                api(libs.koin.core)

                implementation(libs.kotlinx.coroutines.core)
                implementation(libs.sqldelight.coroutines.extensions)
                implementation(libs.ktor.client.core)
            }
        }
    }
}

android {
    namespace = "com.card.business.features.employee.data"
}