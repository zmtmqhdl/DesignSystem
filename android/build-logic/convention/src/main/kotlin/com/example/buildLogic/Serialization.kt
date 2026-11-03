package com.example.buildLogic

import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

internal fun Project.configureSerialization() {
    dependencies {
        add("implementation", libs.findLibrary("kotlinx-serialization-json").get())
    }
}