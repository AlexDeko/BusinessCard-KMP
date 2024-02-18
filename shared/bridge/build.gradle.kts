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
            export(libs.essenty.stateKeeper)
            export(libs.essenty.lifecycle)
            export(libs.essenty.backHandler)
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
                api(project(":shared:core"))
                api(project(":shared:core-utils"))
                api(libs.decompose)
                api(libs.essenty.stateKeeper)
                api(libs.essenty.lifecycle)
                api(libs.essenty.backHandler)
            }
        }
    }
}

android {
    namespace = "com.card.business.bridge"
}