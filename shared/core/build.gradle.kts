plugins {
    id("kotlin.multiplatform")
    alias(libs.plugins.sqlDelight)
    alias(libs.plugins.jetbrainsCompose)
    alias(libs.plugins.kotlinx.serialization)
}
sqldelight {
    databases {
        create("Database") {
            packageName.set("card.business")
        }
    }
}

kotlin {

    sourceSets {
        val commonMain by getting {
            dependencies {
                api(libs.koin.core)
                implementation(libs.kotlinx.coroutines.core)
                implementation(libs.ktor.client.core)
                implementation(libs.ktor.client.content.negotiation)
                implementation(libs.ktor.serialization.kotlinx.json)
                implementation(libs.sqldelight.coroutines.extensions)
                implementation(compose.runtime)
                implementation(compose.foundation)
                implementation(compose.material)
                @OptIn(org.jetbrains.compose.ExperimentalComposeLibrary::class)
                implementation(compose.components.resources)
                api(libs.decompose)
            }
        }

        androidMain {
            dependsOn(commonMain)
            dependencies {
                implementation(libs.android.driver)
                implementation(libs.ktor.client.android)
            }
        }
        val iosX64Main by getting
        val iosArm64Main by getting
        val iosSimulatorArm64Main by getting

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

android {
    namespace = "com.card.business.core"
}

dependencies {
    implementation(libs.androidx.core.ktx)
}