plugins {
    id("android.application")
    id("org.jetbrains.compose")
}

android {
    namespace = "com.card.business.android"
    defaultConfig {
        applicationId = "com.card.business.android"
        versionCode = 1
        versionName = "1.0.0"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
    buildFeatures {
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.4"
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
}

dependencies {
    implementation(project(":shared:core"))
    implementation(project(":shared:core-compose"))
    implementation(project(":shared:bridge"))
    implementation(libs.androidx.activity.compose)
    implementation(libs.androidx.appcompat)
}