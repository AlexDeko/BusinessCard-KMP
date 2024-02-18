plugins {
    id("kotlin.multiplatform")
}

kotlin {
    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(project(":shared:core"))
                implementation(libs.kotlinx.coroutines.core)
                implementation(libs.decompose)
                implementation(libs.koin.core)

            }
        }
    }
}

android {
    namespace = "com.card.business.features.employee_details.presentation"
}