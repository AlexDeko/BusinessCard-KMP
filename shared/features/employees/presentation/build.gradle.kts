plugins {
    id("kotlin.multiplatform")
}

kotlin {
    sourceSets {
        val commonMain by getting {
            dependencies {
                api(project(":shared:features:employees:api"))
                api(project(":shared:core"))
                implementation(libs.kviewmodel)
            }
        }
    }
}

android {
    namespace = "com.card.business.features.employee.api"
}