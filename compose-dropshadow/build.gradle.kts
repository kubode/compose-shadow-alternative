plugins {
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.android.library)
    id("com.github.kubode.compose.shadow.kotlin.common")
    id("com.github.kubode.compose.shadow.android.common")
    id("com.github.kubode.compose.shadow.android.compose")
    id("com.github.kubode.compose.shadow.publish")
}

kotlin {
    explicitApi()
}

android {
    namespace = "com.github.kubode.compose.dropshadow"
    publishing {
        singleVariant("release") {
            withJavadocJar()
            withSourcesJar()
        }
    }
}

publishing {
    publications {
        getByName<MavenPublication>("maven") {
            afterEvaluate {
                from(components["release"])
            }
        }
    }
}

dependencies {
    implementation(libs.androidx.compose.foundation)
}
