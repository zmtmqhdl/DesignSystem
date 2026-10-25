package com.example.buildLogic

import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

internal fun Project.configureHilt() {
    dependencies {
        add("implementation", libs.findLibrary("hilt").get())
        add("ksp", libs.findLibrary("hilt-compiler").get())
    }
}