enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")
pluginManagement {
    includeBuild("build-logic")
    repositories {
        google()
        gradlePluginPortal()
        mavenCentral()
        maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
        maven("https://maven.pkg.jetbrains.space/kotlin/p/kotlin/dev/")
    }
}

dependencyResolutionManagement {
    repositories {
        google()
        mavenCentral()
        maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
        maven("https://maven.pkg.jetbrains.space/kotlin/p/kotlin/dev/")
    }
}

rootProject.name = "Business_card"

include(":androidApp")
include(":shared:bridge")

include(":shared:features:employees:api")
include(":shared:features:employees:presentation")
include(":shared:features:employees:data")
include(":shared:features:employees:compose")

include(":shared:features:sandbox:api")
include(":shared:features:sandbox:presentation")
include(":shared:features:sandbox:compose")

include(":shared:features:employee_details:api")
include(":shared:features:employee_details:presentation")
include(":shared:features:employee_details:compose")

include(":shared:core")
include(":shared:core-compose")
include(":shared:core-utils")
