import java.io.FileInputStream
import java.util.Properties

val projectProperties = Properties().apply {
    load(FileInputStream(rootProject.file("project.properties")))
}

val test = projectProperties["isTest"].toString().toBoolean()

plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)

    // hilt
    alias(libs.plugins.hilt)

    // kps
    alias(libs.plugins.ksp)
}

android {
    namespace = "com.example.designsystem"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.example.designsystem"
        minSdk = 35
        targetSdk = 35
        versionCode = projectProperties["versionCode"].toString().toInt()
        versionName =
            "${projectProperties["major"]}.${projectProperties["minor"]}.${projectProperties["patch"]}"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        debug {
            isShrinkResources = false
            isMinifyEnabled = false
            if (test) {
                resValue("string", "app_name", "DesignSystem (Dev)")
                buildConfigField("boolean", "isTest", "true")
            } else {
                resValue("string", "app_name", "DesignSystem")
                buildConfigField("boolean", "isTest", "false")
            }
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )

            //archivesName.set("mailringx-${projectProperties["major"]}.${projectProperties["minor"]}.${projectProperties["patch"]}-debug")
        }
        release {
            isShrinkResources = true
            isMinifyEnabled = true
            if (test) {
                resValue("string", "app_name", "DesignSystem (Dev)")
                buildConfigField("boolean", "isTest", "true")
            } else {
                resValue("string", "app_name", "DesignSystem")
                buildConfigField("boolean", "isTest", "false")
            }
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
    }
    buildFeatures {
        compose = true
        buildConfig = true
    }
}

dependencies {
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)

    // module
    implementation(project(":data"))
    implementation(project(":domain"))
    implementation(project(":presentation"))

    // hilt
    implementation(libs.hilt)
    ksp(libs.hilt.compiler)

    // room
    implementation(libs.androidx.room.ktx)
    ksp(libs.androidx.room.compiler)
}

//val keystoreProperties = Properties().apply {
//    load(FileInputStream(rootProject.file("keystore.properties")))
//}

//android {
//    namespace = "com.emailphone.android"
//    compileSdk = projectProperties["compileSdk"].toString().toInt()
//
//    defaultConfig {
//        applicationId = if (isTest) "com.emailphone.android" else "com.emailphone.android"
//        minSdk = projectProperties["minSdk"].toString().toInt()
//        targetSdk = projectProperties["targetSdk"].toString().toInt()
//        versionCode = projectProperties["versionCode"].toString().toInt()
//        versionName =
//            "${projectProperties["major"]}.${projectProperties["minor"]}.${projectProperties["patch"]}"
//
//        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
//        buildConfigField("Boolean", "isTest", isTest.toString())
//        vectorDrawables {
//            useSupportLibrary = true
//        }
//    }
//    signingConfigs {
//        create("config") {
//            storeFile = file(keystoreProperties["storeFile"].toString())
//            storePassword = keystoreProperties["storePassword"].toString()
//            keyAlias = keystoreProperties["keyAlias"].toString()
//            keyPassword = keystoreProperties["keyPassword"].toString()
//        }
//    }

//    composeOptions {
//        kotlinCompilerExtensionVersion = libs.versions.composeCompiler.get()
//    }
//    compileOptions {
//        // Flag to enable support for the new language APIs
//        isCoreLibraryDesugaringEnabled = true
//        sourceCompatibility = JavaVersion.VERSION_1_8
//        targetCompatibility = JavaVersion.VERSION_1_8
//    }
//    kotlinOptions {
//        jvmTarget = "1.8"
//    }
//    packaging {
//        resources {
//            excludes += "META-INF/INDEX.LIST"
//            excludes += "META-INF/DEPENDENCIES"
//            excludes += "META-INF/LICENSE"
//            excludes += "META-INF/LICENSE.txt"
//            excludes += "META-INF/license.txt"
//            excludes += "META-INF/NOTICE"
//            excludes += "META-INF/NOTICE.txt"
//            excludes += "META-INF/notice.txt"
//            excludes += "META-INF/ASL2.0"
//            excludes += "META-INF/*.kotlin_module"
//            excludes += "META-INF/io.netty.versions.properties"
//        }
//    }
//}
//