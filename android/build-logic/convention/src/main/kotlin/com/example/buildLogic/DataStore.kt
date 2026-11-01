package com.example.buildLogic

import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

internal fun Project.configureDataStore() {
    dependencies {
        add("implementation", libs.findLibrary("androidx-datastore").get())
        add("implementation", libs.findLibrary("androidx-datastore-preferences").get())
    }
}