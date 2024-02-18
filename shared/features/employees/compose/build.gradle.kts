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
                implementation(project(":shared:features:employees:presentation"))
                implementation(project(":shared:features:employee_details:compose"))
            }
        }
    }
}

android {
    namespace = "com.card.business.features.employee.compose"
}