plugins {
    id("kotlin.multiplatform")
    alias(libs.plugins.jetbrainsCompose)
}

kotlin {

    sourceSets {
        val commonMain by getting {
            dependencies {
                api(project(":shared:core-compose"))
                api(project(":shared:features:employees:api"))
                implementation(project(":shared:core-utils"))
                api(project(":shared:core"))
                implementation(libs.koin.compose)
                api(project(":shared:features:employees:presentation"))
            }
        }
    }
}

android {
    namespace = "com.card.business.features.employee.compose"
}