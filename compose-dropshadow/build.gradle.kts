plugins {
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.android.library)
    alias(libs.plugins.maven.publish)
    id("io.github.kubode.compose.shadow.kotlin.common")
    id("io.github.kubode.compose.shadow.android.common")
    id("io.github.kubode.compose.shadow.android.compose")
}

kotlin {
    explicitApi()
}

android {
    namespace = "io.github.kubode.compose.dropshadow"
}

dependencies {
    implementation(libs.androidx.compose.foundation)
}
