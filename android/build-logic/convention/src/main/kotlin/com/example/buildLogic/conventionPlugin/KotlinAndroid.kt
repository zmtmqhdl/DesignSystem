package com.example.buildLogic.conventionPlugin

import com.android.build.api.dsl.CommonExtension
import com.example.buildLogic.libs
import org.gradle.api.JavaVersion
import org.gradle.api.Project
import org.gradle.api.plugins.JavaPluginExtension
import org.gradle.kotlin.dsl.assign
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.dependencies
import org.jetbrains.kotlin.gradle.dsl.JvmTarget
import org.jetbrains.kotlin.gradle.dsl.KotlinAndroidProjectExtension
import org.jetbrains.kotlin.gradle.dsl.KotlinBaseExtension
import org.jetbrains.kotlin.gradle.dsl.KotlinJvmProjectExtension

internal fun Project.configureKotlinAndroid(
    commonExtension: CommonExtension,
) {
    commonExtension.apply {
        compileSdk = 37

        defaultConfig.apply {
            minSdk = 24
        }

        compileOptions.apply {
            sourceCompatibility = JavaVersion.VERSION_21
            targetCompatibility = JavaVersion.VERSION_21
        }
    }

    configureKotlin<KotlinAndroidProjectExtension>()
}

internal fun Project.configureKotlinJvm() {
    extensions.configure<JavaPluginExtension> {
        sourceCompatibility = JavaVersion.VERSION_21
        targetCompatibility = JavaVersion.VERSION_21
    }

    configureKotlin<KotlinJvmProjectExtension>()
}

private inline fun <reified T : KotlinBaseExtension> Project.configureKotlin() = configure<T> {
    val warningsAsErrors = providers.gradleProperty("warningsAsErrors").map {
        it.toBoolean()
    }.orElse(false)
    when (this) {
        is KotlinAndroidProjectExtension -> compilerOptions
        is KotlinJvmProjectExtension -> compilerOptions
        else -> TODO("Unsupported project extension $this ${T::class}")
    }.apply {
        jvmTarget = JvmTarget.JVM_21
        allWarningsAsErrors = warningsAsErrors
        freeCompilerArgs.add("-opt-in=kotlinx.coroutines.ExperimentalCoroutinesApi")
        /**
         * Remove this args after Phase 3.
         * https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-consistent-copy-visibility/#deprecation-timeline
         *
         * Deprecation timeline
         * Phase 3. (Supposedly Kotlin 2.2 or Kotlin 2.3).
         * The default changes.
         * Unless ExposedCopyVisibility is used, the generated 'copy' method has the same visibility as the primary constructor.
         * The binary signature changes. The error on the declaration is no longer reported.
         * '-Xconsistent-data-class-copy-visibility' compiler flag and ConsistentCopyVisibility annotation are now unnecessary.
         */
        freeCompilerArgs.add("-Xconsistent-data-class-copy-visibility")
//        freeCompilerArgs.add("-XXLanguage:+PropertyParamAnnotationDefaultTargetMode")
    }
}