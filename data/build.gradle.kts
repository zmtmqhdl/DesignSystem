plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)

    // ksp
    alias(libs.plugins.ksp)
}

android {
    namespace = "com.example.data"
    compileSdk = rootProject.extra["compileSdk"] as Int

    defaultConfig {
        minSdk = rootProject.extra["minSdk"] as Int

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
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
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    kotlinOptions {
        jvmTarget = "17"
        freeCompilerArgs = listOf("-XXLanguage:+PropertyParamAnnotationDefaultTargetMode")
    }
}

dependencies {
    implementation(libs.androidx.core.ktx)
    implementation(libs.material)
    androidTestImplementation(libs.androidx.espresso.core)

    // data store
    implementation(libs.androidx.datastore.preferences)

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
    implementation(libs.converter.gson)

    // room
    implementation(libs.androidx.room.ktx)
    ksp(libs.androidx.room.compiler)

    // okhttp3
    implementation(libs.logging.interceptor)

    // serialization
    implementation(libs.kotlinx.serialization.json)
    implementation(libs.retrofit2.kotlinx.serialization.converter)
}