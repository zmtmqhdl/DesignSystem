import com.example.buildLogic.configureRoom
import org.gradle.api.Plugin
import org.gradle.api.Project
//import androidx.room.gradle.RoomExtension

class AndroidLibraryRoomConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            pluginManager.apply("com.google.devtools.ksp")
            pluginManager.apply("androidx.room")

//            extensions.configure<RoomExtension> {
//                schemaDirectory("$projectDir/schemas")
//            }

            configureRoom()
        }
    }
}