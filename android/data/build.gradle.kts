import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)

    // ksp
    alias(libs.plugins.ksp)

    // kotlinx
    alias(libs.plugins.kotlin.serialization)

    // proto
    alias(libs.plugins.protobuf)
}

android {
    namespace = "com.example.data"
    compileSdk = rootProject.extra["compileSdk"] as Int

    defaultConfig {
        minSdk = rootProject.extra["minSdk"] as Int

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    flavorDimensions += "env"
    productFlavors {
        create("dev") {
            dimension = "env"
            buildConfigField("Boolean", "IS_DEV", "true")
        }
        create("prod") {
            dimension = "env"
            buildConfigField("Boolean", "IS_DEV", "false")
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_21
        targetCompatibility = JavaVersion.VERSION_21
    }
    kotlin {
        compilerOptions {
            jvmTarget = JvmTarget.JVM_21
        }
    }
    buildFeatures {
        buildConfig = true
    }

}

dependencies {
    implementation(libs.androidx.core.ktx)
    implementation(libs.material)
    androidTestImplementation(libs.androidx.espresso.core)

    // data store
    implementation(libs.androidx.datastore.preferences)
    implementation(libs.androidx.datastore)
    implementation(libs.protobuf.javalite)

    // module
    implementation(project(":domain"))
    implementation(project(":core"))


    // coroutines
    implementation(libs.kotlinx.coroutines.android)

    // hilt
    implementation(libs.hilt)
    ksp(libs.hilt.compiler)

    // retrofit
    implementation(libs.retrofit)

    // room
    implementation(libs.androidx.room.ktx)
    ksp(libs.androidx.room.compiler)

    // okhttp3
    implementation(libs.logging.interceptor)

    // serialization
    implementation(libs.kotlinx.serialization.json)
    implementation(libs.retrofit2.kotlinx.serialization.converter)
}

protobuf {
    protoc {
        artifact = "com.google.protobuf:protoc:3.21.12"
    }
    generateProtoTasks {
        all().forEach { task ->
            task.builtins {
                create("java") {
                    option("lite")
                }
            }
        }
    }
}