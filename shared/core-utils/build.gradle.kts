

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
                implementation(libs.kotlinx.coroutines.core)
                api(project(":shared:core-compose"))
            }
        }
    }
}


android {
    namespace = "com.card.business.core.utils"
}