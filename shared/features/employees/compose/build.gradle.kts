plugins {
    id("kotlin.multiplatform")
    alias(libs.plugins.jetbrainsCompose)
}

kotlin {

    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(project(":shared:core-compose"))
            }
        }
    }
}

android {
    namespace = "com.card.business.features.employee.compose"
}