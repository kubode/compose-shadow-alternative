plugins {
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.compose.multiplatform)
    alias(libs.plugins.android.library)
    id("com.github.kubode.compose.shadow.kotlin.common")
    id("com.github.kubode.compose.shadow.compose.multiplatform")
    id("com.github.kubode.compose.shadow.android.common")
    id("com.github.kubode.compose.shadow.publish")
}

kotlin {
    jvm()
    androidTarget {
        publishLibraryVariants("release")
    }
    iosArm64()
    iosX64()
    iosSimulatorArm64()

    explicitApi()

    sourceSets {
        commonMain {
            dependencies {
                implementation(compose.ui)
            }
        }
    }
}

android {
    namespace = "com.github.kubode.compose.boxshadow"
}
