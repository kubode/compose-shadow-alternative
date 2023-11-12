plugins {
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.compose.multiplatform)
    id("io.github.kubode.compose.shadow.kotlin.common")
    id("io.github.kubode.compose.shadow.compose.multiplatform")
}

kotlin {
    js {
        browser()
        binaries.executable()
    }
    sourceSets {
        jsMain {
            dependencies {
                implementation(projects.sample.shared)
                implementation(compose.foundation)
            }
        }
    }
}

compose.experimental {
    web.application {}
}
