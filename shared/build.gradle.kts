plugins {
    id("kotlin.multiplatform")
    alias(libs.plugins.sqlDelight)
    kotlin("plugin.serialization") version "1.9.10"
}

sqldelight {
    databases {
        create("Database") {
            packageName.set("card.business")
        }
    }
}

kotlin {
    cocoapods {
        summary = "Some description for the Shared Module"
        homepage = "Link to the Shared Module homepage"
        version = "1.0"
        ios.deploymentTarget = "16.0"
        podfile = project.file("../iosApp/Podfile")
        framework {
            baseName = "shared"
            isStatic = true
        }
    }
}

android {
    namespace = "com.card.business"

    sourceSets {
        val iosMain by creating {
            dependsOn(commonMain)
            dependencies {
                implementation(libs.native.driver)
                implementation(libs.ktor.client.darwin)
            }
            iosX64Main.dependsOn(this)
            iosArm64Main.dependsOn(this)
            iosSimulatorArm64Main.dependsOn(this)
        }
    }
}

dependencies {
    implementation(libs.androidx.core.ktx)

    commonMainImplementation(libs.kotlinx.coroutines.core)
    commonMainImplementation(libs.ktor.client.core)
    commonMainImplementation(libs.ktor.client.content.negotiation)
    commonMainImplementation(libs.ktor.serialization.kotlinx.json)
    commonMainImplementation(libs.sqldelight.coroutines.extensions)

    androidMainImplementation(libs.android.driver)
    androidMainImplementation(libs.ktor.client.android)

    commonTestImplementation(libs.kotlin.test)
}