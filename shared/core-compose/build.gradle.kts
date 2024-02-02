plugins {
    id("kotlin.multiplatform")
    alias(libs.plugins.jetbrainsCompose)
}

kotlin {
    sourceSets {
        commonMain {
            dependencies {
                implementation(compose.runtime)
                implementation(compose.foundation)
                implementation(compose.material)
                implementation(compose.ui)
                implementation(compose.material3)
                @OptIn(org.jetbrains.compose.ExperimentalComposeLibrary::class)
                implementation(compose.components.resources)
                implementation(libs.decompose)
                implementation(libs.decompose.jetbrains.compose.extensions)
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