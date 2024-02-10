plugins {
    id("kotlin.multiplatform")
}

kotlin {
    sourceSets {
        val commonMain by getting {
            dependencies {
                api(project(":shared:features:employees:api"))
                implementation(project(":shared:core"))
                implementation(libs.kotlinx.coroutines.core)
                implementation(libs.decompose)
            }
        }
    }
}

android {
    namespace = "com.card.business.features.employee_details.presentation"
}