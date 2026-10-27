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
//    compileOnly(libs.room.gradlePlugin)
//    compileOnly(libs.ksp.gradlePlugin)
}

gradlePlugin {
    plugins {
        // app
        create("androidApplication") {
            id = "android.application.convention.plugin"
            implementationClass = "AndroidApplicationConventionPlugin"
        }
        create("androidApplicationCompose") {
            id = "android.application.compose.convention.plugin"
            implementationClass = "AndroidApplicationComposeConventionPlugin"
        }
        create("androidApplicationHilt") {
            id = "android.application.hilt.convention.plugin"
            implementationClass = "AndroidApplicationHiltConventionPlugin"
        }

        // library
        create("androidLibrary") {
            id = "android.library.convention.plugin"
            implementationClass = "AndroidLibraryConventionPlugin"
        }
        create("androidLibraryCompose") {
            id = "android.library.compose.convention.plugin"
            implementationClass = "AndroidLibraryComposeConventionPlugin"
        }
        create("androidLibraryHilt") {
            id = "android.library.hilt.convention.plugin"
            implementationClass = "AndroidLibraryHiltConventionPlugin"
        }
    }
}