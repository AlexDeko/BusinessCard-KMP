plugins {
    id("android.application")
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
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
}

dependencies {
    implementation(project(":shared:core"))
    implementation(project(":shared:bridge"))
    implementation(libs.androidx.appcompat)
}