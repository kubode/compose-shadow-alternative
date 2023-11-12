plugins {
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.compose.multiplatform)
    alias(libs.plugins.android.library)
    id("io.github.kubode.compose.shadow.kotlin.common")
    id("io.github.kubode.compose.shadow.compose.multiplatform")
    id("io.github.kubode.compose.shadow.android.common")
}

kotlin {
    jvm()
    androidTarget()
    iosArm64()
    iosX64()
    iosSimulatorArm64()
    macosArm64()
    macosX64()
    js {
        browser()
    }

    explicitApi()

    sourceSets {
        commonMain {
            dependencies {
                implementation(compose.material)
                implementation(projects.composeBoxshadow)
            }
        }
        androidMain {
            dependencies {
                implementation(projects.composeDropshadow)
            }
        }
    }
}

android {
    namespace = "io.github.kubode.compose.shadow.sample.shared"
}
