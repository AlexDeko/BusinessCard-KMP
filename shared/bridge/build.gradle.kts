plugins {
    id("kotlin.multiplatform")
    id("org.jetbrains.kotlin.native.cocoapods")
    alias(libs.plugins.kotlinx.serialization)
    id("org.jetbrains.compose")
}

kotlin {
    cocoapods {
        summary = "Business card iOS"
        homepage = "https://github.com/AlexDeko/BusinessCard-KMP"
        version = "1.0.0"
        ios.deploymentTarget = "16.0"
        framework {
            baseName = "bridge"
            isStatic = false
            transitiveExport = false
            linkerOpts("-lsqlite3")
            export(project(":shared:core"))
            export(project(":shared:core-utils"))
            export(libs.decompose)
            export(libs.decompose.jetbrains.compose.extensions)
            export(libs.essenty.lifecycle)
        }
    }

    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(libs.koin.core)
                implementation(libs.decompose)
                implementation(project(":shared:core"))
                implementation(project(":shared:core-compose"))
                implementation(project(":shared:features:sandbox:presentation"))
                implementation(project(":shared:features:employees:presentation"))
                implementation(project(":shared:features:sandbox:api"))
                implementation(project(":shared:features:employees:api"))
                implementation(project(":shared:features:employees:compose"))
                implementation(project(":shared:features:sandbox:compose"))

            }
        }

        iosMain {
            dependencies {
                implementation(project(":shared:core"))
                implementation(project(":shared:core-utils"))
                implementation(libs.decompose)
                implementation(libs.koin.core)
                implementation(libs.decompose.jetbrains.compose.extensions)
                implementation(libs.essenty.lifecycle)
            }
        }
    }
}

android {
    namespace = "com.card.business.bridge"
}