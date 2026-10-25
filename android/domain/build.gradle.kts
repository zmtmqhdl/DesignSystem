plugins {
    id("android.library.convention.plugin")
    id("android.library.hilt.convention.plugin")
}

android {
    namespace = "com.example.domain"

    buildFeatures {
        buildConfig = true
    }
}

dependencies {
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.paging.common)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    implementation(libs.kotlinx.coroutines.android)
}