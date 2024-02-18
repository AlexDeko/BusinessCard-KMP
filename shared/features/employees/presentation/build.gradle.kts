plugins {
    id("kotlin.multiplatform")
    alias(libs.plugins.kotlinx.serialization)
}

kotlin {
    sourceSets {
        val commonMain by getting {
            dependencies {
                api(project(":shared:features:employees:api"))
                implementation(project(":shared:core"))
                implementation(project(":shared:features:employees:data"))
                implementation(libs.kotlinx.coroutines.core)
                implementation(libs.ktor.client.core)
                implementation(libs.decompose)
                implementation(libs.koin.core)
            }
        }
    }
}

android {
    namespace = "com.card.business.features.employee.api"
}