import com.example.buildLogic.configureRoom
import org.gradle.api.Plugin
import org.gradle.api.Project

class AndroidLibraryProtobufConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            pluginManager.apply("com.google.devtools.ksp")
            pluginManager.apply("androidx.room")

            configureRoom()
        }
    }
}