plugins {
    id("kotlin.multiplatform")
    alias(libs.plugins.kotlinx.serialization)
}

kotlin {
    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(project(":shared:features:sandbox:api"))
                implementation(project(":shared:core"))
                implementation(libs.decompose)
                implementation(libs.koin.core)
            }
        }
    }
}

android {
    namespace = "com.card.business.features.sandbox.presentation"
}