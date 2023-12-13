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
                @OptIn(org.jetbrains.compose.ExperimentalComposeLibrary::class)
                implementation(compose.components.resources)
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