import org.gradle.kotlin.dsl.configure
import com.example.buildLogic.configureProtobuf
import com.example.buildLogic.libs
import com.google.protobuf.gradle.ProtobufExtension
import org.gradle.api.Plugin
import org.gradle.api.Project

class AndroidLibraryProtobufConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            pluginManager.apply("com.google.protobuf")

            extensions.configure<ProtobufExtension> {
                protoc {
                    artifact = "com.google.protobuf:protoc:${libs.findVersion("protobuf").get().requiredVersion}"
                }

                generateProtoTasks {
                    all().forEach { task ->
                        task.builtins {
                            create("java") {
                                option("lite")
                            }

                            create("kotlin") {
                                option("lite")
                            }
                        }
                    }
                }
            }

            configureProtobuf()
        }
    }
}