import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.`kotlin-dsl`
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
    compileOnly(libs.kotlin.gradlePlugin)
}

gradlePlugin {
    plugins {
        create("androidLibrary") {
            id = "android.library.convention.plugin"
            implementationClass = "AndroidLibraryConventionPlugin"
        }
        create("androidLibraryCompose") {
            id = "android.library.compose.convention.plugin"
            implementationClass = "AndroidLibraryComposeConventionPlugin"
        }
    }
}