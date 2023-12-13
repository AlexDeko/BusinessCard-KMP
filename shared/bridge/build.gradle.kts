plugins {
    id("kotlin.multiplatform")
    id("org.jetbrains.kotlin.native.cocoapods")
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
                implementation(project(":shared:features:employees:data"))
            }
        }

        val iosX64Main by getting
        val iosArm64Main by getting
        val iosSimulatorArm64Main by getting
        val iosMain by creating {
            dependencies {
                api(project(":shared:core"))
                api(project(":shared:core-utils"))
            }

            iosX64Main.dependsOn(this)
            iosArm64Main.dependsOn(this)
            iosSimulatorArm64Main.dependsOn(this)
        }
    }
}

android {
    namespace = "com.card.business.bridge"
}