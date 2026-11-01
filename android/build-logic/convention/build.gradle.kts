import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    `kotlin-dsl`
}

group = "com.example.buildlogic"

java {
    sourceCompatibility = JavaVersion.VERSION_21
    targetCompatibility = JavaVersion.VERSION_21
}

kotlin {
    compilerOptions {
        jvmTarget.set(JvmTarget.JVM_21)
    }
}

dependencies {
    compileOnly(libs.android.gradlePlugin)
    compileOnly(libs.ksp.gradlePlugin)
    compileOnly(libs.compose.gradlePlugin)
    compileOnly(libs.kotlin.gradlePlugin)
    compileOnly(libs.room.gradlePlugin)
}

gradlePlugin {
    plugins {
        // app
        register("androidApplication") {
            id = libs.plugins.android.application.convention.get().pluginId
            implementationClass = "AndroidApplicationConventionPlugin"
        }
        register("androidApplicationCompose") {
            id = libs.plugins.android.application.compose.get().pluginId
            implementationClass = "AndroidApplicationComposeConventionPlugin"
        }
        register("androidApplicationHilt") {
            id = libs.plugins.android.application.hilt.get().pluginId
            implementationClass = "AndroidApplicationHiltConventionPlugin"
        }

        // library
        register("androidLibrary") {
            id = libs.plugins.android.library.convention.get().pluginId
            implementationClass = "AndroidLibraryConventionPlugin"
        }
        register("androidLibraryCompose") {
            id = libs.plugins.android.library.compose.get().pluginId
            implementationClass = "AndroidLibraryComposeConventionPlugin"
        }
        register("androidLibraryHilt") {
            id = libs.plugins.android.library.hilt.get().pluginId
            implementationClass = "AndroidLibraryHiltConventionPlugin"
        }
        register("androidLibraryRoom") {
            id = libs.plugins.android.library.room.get().pluginId
            implementationClass = "AndroidLibraryRoomConventionPlugin"
        }
    }
}