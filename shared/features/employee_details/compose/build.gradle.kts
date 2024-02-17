plugins {
    id("kotlin.multiplatform")
    alias(libs.plugins.jetbrainsCompose)
}

kotlin {

    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(project(":shared:core-compose"))
                implementation(project(":shared:core-utils"))
                implementation(project(":shared:core"))
                implementation(libs.koin.compose)
                implementation(project(":shared:features:employees:api"))
                implementation(project(":shared:features:employee_details:presentation"))
            }
        }
    }
}

android {
    namespace = "com.card.business.features.employee_details.compose"
}