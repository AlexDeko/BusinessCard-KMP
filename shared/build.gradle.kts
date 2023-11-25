plugins {
    id("kotlin.multiplatform")
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

dependencies {
    commonTestImplementation(libs.kotlin.test)
}

android {
    namespace = "com.card.business"
}