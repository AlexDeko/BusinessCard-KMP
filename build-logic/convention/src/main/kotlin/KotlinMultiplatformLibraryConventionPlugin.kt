import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import org.jetbrains.kotlin.gradle.dsl.KotlinMultiplatformExtension
import org.jetbrains.kotlin.gradle.plugin.cocoapods.CocoapodsExtension

class KotlinMultiplatformLibraryConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply("org.jetbrains.kotlin.multiplatform")
                apply("org.jetbrains.kotlin.native.cocoapods")
                apply("android.library")
            }

            extensions.configure<KotlinMultiplatformExtension> {
                androidTarget {
                    compilations.all {
                        kotlinOptions {
                            jvmTarget = "1.8"
                        }
                    }
                }
                iosX64()
                iosArm64()
                iosSimulatorArm64()

                (this as org.gradle.api.plugins.ExtensionAware)
                    .extensions.configure<CocoapodsExtension>("cocoapods") {
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
        }
    }
}