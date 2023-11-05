plugins {
    id("com.github.kubode.compose.shadow.kotlin.common")
    id("com.github.kubode.compose.shadow.android.common")
    id("com.github.kubode.compose.shadow.android.compose")
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

dependencies {
    implementation(libs.androidx.compose.foundation)
}
