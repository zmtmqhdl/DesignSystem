import com.example.buildLogic.configureHilt
import org.gradle.api.Plugin
import org.gradle.api.Project

class AndroidLibraryHiltConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            pluginManager.apply("com.google.devtools.ksp")

            configureHilt()
        }
    }
}