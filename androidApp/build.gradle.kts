plugins {
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.android.application)
}

kotlin {
    jvmToolchain(19)
}

android {
    namespace = "com.github.kubode.compose.shadow.android"
    compileSdk = 34
    defaultConfig {
        applicationId = "com.github.kubode.compose.shadow.android"
        minSdk = 26
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"
    }
    buildFeatures {
        compose = true
        composeOptions {
            kotlinCompilerExtensionVersion = libs.versions.androidx.compose.compiler.get()
        }
    }
}

dependencies {
    implementation(project(":compose-boxshadow"))
    implementation(project(":compose-dropshadow"))
    implementation(libs.androidx.activity.compose)
    implementation(libs.androidx.compose.foundation)
    implementation(libs.androidx.compose.ui.tooling)
    debugImplementation(libs.androidx.compose.ui.tooling.preview)
}
