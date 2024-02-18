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
            }
        }
    }
}

android {
    namespace = "com.card.business.features.sandbox.api"
}