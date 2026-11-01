import com.example.buildLogic.configureDataStore
import org.gradle.api.Plugin
import org.gradle.api.Project

class AndroidLibraryDataStoreConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            configureDataStore()
        }

    }
}