import com.android.build.api.dsl.TestExtension
import com.android.build.api.variant.TestAndroidComponentsExtension
import com.example.buildLogic.configureKotlin
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure

@Suppress("UnstableApiUsage")
class AndroidTestConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            pluginManager.apply("com.android.test")

            extensions.configure<TestExtension> {
                configureKotlin(this)

                defaultConfig {
                    targetSdk = 37
                    testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
                    testInstrumentationRunnerArguments["androidx.benchmark.suppressErrors"] = "EMULATOR"
                }

                buildTypes {
                    create("benchmark") {
                        isDebuggable = true
                        signingConfig = getByName("debug").signingConfig
                        matchingFallbacks += listOf("release")
                    }
                }

                flavorDimensions += "env"

                productFlavors {
                    create("dev") { dimension = "env" }
                    create("prod") { dimension = "env" }
                }

                targetProjectPath = ":app"
                experimentalProperties["android.experimental.self-instrumenting"] = true
            }

            extensions.configure<TestAndroidComponentsExtension> {
                beforeVariants(selector().all()) {
                    it.enable = it.buildType == "benchmark"
                }
            }
        }
    }
}