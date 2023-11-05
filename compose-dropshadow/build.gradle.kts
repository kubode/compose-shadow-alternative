plugins {
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.android.library)
    id("com.github.kubode.compose.shadow.kotlin.common")
    id("com.github.kubode.compose.shadow.android.common")
    id("com.github.kubode.compose.shadow.android.compose")
}

kotlin {
    explicitApi()
}

android {
    namespace = "com.github.kubode.compose.dropshadow"
}

dependencies {
    implementation(libs.androidx.compose.foundation)
}
