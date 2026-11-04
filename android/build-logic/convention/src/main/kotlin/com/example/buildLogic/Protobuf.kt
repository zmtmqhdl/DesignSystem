package com.example.buildLogic

import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

internal fun Project.configureProtobuf() {
    dependencies {
        add("implementation", libs.findLibrary("protobuf-javalite").get())
        add("implementation", libs.findLibrary("protobuf-kotlin-lite").get())
    }

}