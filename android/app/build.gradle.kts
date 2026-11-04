import com.android.build.api.dsl.ApplicationExtension

plugins {
    id("android.application.convention.plugin")
    id("android.application.compose.convention.plugin")
    id("android.application.hilt.convention.plugin")
}

extensions.configure<ApplicationExtension> {
    namespace = "com.example.designsystem"

    defaultConfig {
        applicationId = "com.example.designsystem"
        versionCode = 1
        versionName = "1.0.0"
    }
}

dependencies {
    implementation(project(":data"))
    implementation(project(":domain"))
    implementation(project(":core"))
    implementation(project(":presentation"))
    implementation(project(":common"))

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(libs.androidx.appcompat)
    androidTestImplementation(libs.androidx.test.ext)
    androidTestImplementation(libs.androidx.test.espresso.core)
    implementation(libs.androidx.core.splashscreen)
}