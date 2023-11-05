plugins {
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.android.application)
    id("com.github.kubode.compose.shadow.kotlin.common")
    id("com.github.kubode.compose.shadow.android.common")
    id("com.github.kubode.compose.shadow.android.compose")
}

android {
    namespace = "com.github.kubode.compose.shadow.android"
    defaultConfig {
        applicationId = "com.github.kubode.compose.shadow.android"
        minSdk = 26 // Adaptive icon requires API 26
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"
    }
}

dependencies {
    implementation(projects.composeBoxshadow)
    implementation(projects.composeDropshadow)
    implementation(libs.androidx.activity.compose)
    implementation(libs.androidx.compose.foundation)
    implementation(libs.androidx.compose.ui.tooling)
    debugImplementation(libs.androidx.compose.ui.tooling.preview)
}
