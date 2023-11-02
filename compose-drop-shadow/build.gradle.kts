plugins {
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.compose.multiplatform)
    alias(libs.plugins.android.library)
}

kotlin {
    jvm()
    androidTarget()
    iosArm64()
    iosX64()
    iosSimulatorArm64()
}

android {
    namespace = "com.github.kubode.compose.dropshadow"
}
