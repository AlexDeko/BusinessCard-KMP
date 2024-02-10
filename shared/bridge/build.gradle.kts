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
        }
    }

    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(project(":shared:core"))
                api(project(":shared:core-compose"))

                implementation(project(":shared:features:employees:presentation"))
                implementation(project(":shared:features:employees:compose"))
            }
        }

        iosMain {
            dependencies {
                api(project(":shared:core"))
                api(project(":shared:core-utils"))
            }
        }
    }
}

android {
    namespace = "com.card.business.bridge"
}