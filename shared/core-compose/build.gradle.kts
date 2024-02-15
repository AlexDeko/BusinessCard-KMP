plugins {
    id("kotlin.multiplatform")
    alias(libs.plugins.jetbrainsCompose)
}

kotlin {
    sourceSets {
        commonMain {
            dependencies {
                api(compose.runtime)
                api(compose.foundation)
                api(compose.material)
                api(compose.ui)
                api(compose.material3)
                @OptIn(org.jetbrains.compose.ExperimentalComposeLibrary::class)
                api(compose.components.resources)
                api(libs.decompose)
                api(libs.decompose.jetbrains.compose.extensions)
            }
        }
    }
}

android {
    namespace = "com.card.business.core.compose"
}

dependencies {
    implementation(libs.androidx.core.ktx)
}