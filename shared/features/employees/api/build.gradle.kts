plugins {
    id("kotlin.multiplatform")
    alias(libs.plugins.kotlinx.serialization)
}

kotlin {

    sourceSets {
        commonMain {
            dependencies {
                implementation(project(":shared:core"))
                implementation(libs.koin.core)
                implementation(libs.kotlinx.coroutines.core)
                implementation(libs.kotlinx.serialization.json)
                implementation(libs.decompose)
            }
        }
    }
}

android {
    namespace = "com.card.business.features.employee.api"
}