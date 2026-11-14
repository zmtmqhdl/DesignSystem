plugins {
    id("android.test.convention.plugin")
    alias(libs.plugins.android.test)
}

android {
    namespace = "com.example.macrobenchmark"
}

dependencies {
    implementation(libs.androidx.benchmark.macro.junit4)
    implementation(libs.androidx.junit)
    implementation(libs.androidx.test.espresso.core)
    implementation(libs.androidx.uiautomator)
}