plugins {
    id("kotlin.multiplatform")
}

kotlin {
    sourceSets {
        val commonMain by getting {
            dependencies {
                api(project(":shared:features:employees:api"))
                implementation(project(":shared:core"))
                implementation(project(":shared:features:employees:data"))
                implementation(libs.kotlinx.coroutines.core)
            }
        }
    }
}

android {
    namespace = "com.card.business.features.employee.api"
}