plugins {
    id("kotlin.multiplatform")
}

kotlin {
    sourceSets {
        val commonMain by getting {
            dependencies {
                api(project(":shared:features:employees:api"))
                api(project(":shared:core"))
                api(libs.koin.core)
                implementation(libs.kotlinx.coroutines.core)
            }
        }
    }
}

android {
    namespace = "com.card.business.features.employee.api"
}