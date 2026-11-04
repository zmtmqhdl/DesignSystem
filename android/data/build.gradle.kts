plugins {
    id("android.library.convention.plugin")
    id("android.library.datastore.convention.plugin")
    id("android.library.hilt.convention.plugin")
    id("android.library.protobuf.convention.plugin")
    id("android.library.room.convention.plugin")
    id("android.library.serialization.convention.plugin")
}

android {
    namespace = "com.example.data"
}

dependencies {
    implementation(project(":domain"))
    implementation(project(":core"))

    implementation(libs.androidx.core.ktx)
    androidTestImplementation(libs.androidx.test.espresso.core)
    implementation(libs.kotlinx.coroutines.android)
    implementation(libs.retrofit.core)
    implementation(libs.logging.interceptor)
    implementation(libs.retrofit.kotlin.serialization)
    implementation(libs.androidx.paging.runtime)
    implementation(libs.coil.compose)
    implementation(libs.coil.network.okhttp)
}

