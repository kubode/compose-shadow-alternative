plugins {
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.compose.multiplatform)
    alias(libs.plugins.android.application)
}

kotlin {
    jvmToolchain(19)

    androidTarget()

    sourceSets {
        androidMain {
            dependencies {
                implementation(project(":compose-drop-shadow"))
                implementation(libs.androidx.activity.compose)
                implementation(compose.foundation)
                implementation(compose.ui)
                implementation(compose.uiTooling)
                implementation(compose.preview)
            }
        }
    }
}

android {
    namespace = "com.github.kubode.compose.dropshadow.android"
    compileSdk = 34
    defaultConfig {
        applicationId = "com.github.kubode.compose.dropshadow.android"
        minSdk = 21
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"
    }
}
