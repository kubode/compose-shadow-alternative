plugins {
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.android.library)
}

kotlin {
    jvmToolchain(19)
    explicitApi()
}

android {
    namespace = "com.github.kubode.compose.dropshadow"
    compileSdk = 34
    defaultConfig {
        minSdk = 21
    }
    buildFeatures {
        compose = true
        composeOptions {
            kotlinCompilerExtensionVersion = libs.versions.androidx.compose.compiler.get()
        }
    }
}
