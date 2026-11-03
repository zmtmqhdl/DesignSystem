import com.android.build.api.dsl.ApplicationExtension
import com.example.buildLogic.configureKotlin
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure

class AndroidApplicationConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            pluginManager.apply("com.android.application")

            extensions.configure<ApplicationExtension> {
                configureKotlin(this)
                defaultConfig.targetSdk = 37
                defaultConfig.testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"

                buildFeatures {
                    buildConfig = true
                    resValues = true
                }

                buildTypes {
                    getByName("debug") {
                        isMinifyEnabled = false
                        applicationIdSuffix = ".debug"
                        versionNameSuffix = "-debug"
                    }
                    getByName("release") {
                        isMinifyEnabled = true
                        isShrinkResources = true
                        signingConfig = signingConfigs.getByName("debug")
                        proguardFiles(
                            getDefaultProguardFile("proguard-android-optimize.txt"),
                            "proguard-rules.pro"
                        )
                    }
                }

                flavorDimensions += "env"
                productFlavors {
                    create("dev") {
                        dimension = "env"
                        applicationIdSuffix = ".dev"
                        versionNameSuffix = "-dev"
                        resValue("string", "app_name", "DesignSystem (Dev)")
                    }
                    create("prod") {
                        dimension = "env"
                        resValue("string", "app_name", "DesignSystem")
                    }
                }
            }
        }
    }

}