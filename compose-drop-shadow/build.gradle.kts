plugins {
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.compose.multiplatform)
    alias(libs.plugins.android.library)
}

kotlin {
    jvmToolchain(19)

    jvm()
    androidTarget()
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
    namespace = "com.github.kubode.compose.dropshadow"
    compileSdk = 34
}
