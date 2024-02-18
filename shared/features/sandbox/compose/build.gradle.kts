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
                implementation(project(":shared:features:sandbox:presentation"))
                implementation(project(":shared:features:sandbox:api"))
                implementation(libs.koin.compose)
            }
        }
    }
}

android {
    namespace = "com.card.business.features.sandbox.compose"
}