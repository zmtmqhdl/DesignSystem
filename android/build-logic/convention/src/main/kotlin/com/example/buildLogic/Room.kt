package com.example.buildLogic

import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

internal fun Project.configureRoom() {
    dependencies {
        add("implementation", libs.findLibrary("room-ktx").get())
        add("implementation", libs.findLibrary("androidx-room-paging").get())
        add("ksp", libs.findLibrary("androidx-room-compiler").get())
    }
}