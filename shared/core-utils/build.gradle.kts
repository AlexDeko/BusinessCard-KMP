

plugins {
    id("kotlin.multiplatform")
}
kotlin {
    sourceSets {
        val androidMain by getting {
            dependencies {
                implementation(libs.androidx.lifecycle.runtime.compose)
            }
        }

        val commonMain by getting {
            dependencies {
                implementation(libs.koin.core)
                implementation(libs.kotlinx.coroutines.core)
                implementation(project(":shared:core-compose"))
            }
        }
    }
}


android {
    namespace = "com.card.business.core.utils"
}