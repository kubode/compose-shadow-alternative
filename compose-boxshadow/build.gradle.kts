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
    macosArm64()
    macosX64()
    js {
        browser()
    }

    explicitApi()

    sourceSets {
        commonMain {
            dependencies {
                implementation(compose.ui)
            }
        }
        val nonAndroidMain by creating {
            dependsOn(commonMain.get())
        }
        listOf(
            jvmMain.get(),
            getByName("iosArm64Main"),
            getByName("iosX64Main"),
            getByName("iosSimulatorArm64Main"),
            getByName("macosArm64Main"),
            getByName("macosX64Main"),
            jsMain.get(),
        ).forEach { it.dependsOn(nonAndroidMain) }
    }
}

android {
    namespace = "com.github.kubode.compose.boxshadow"
}
