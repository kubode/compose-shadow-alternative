pluginManagement {
    includeBuild("build-logic")
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
    }
}

dependencyResolutionManagement {
    repositories {
        // TODO: Awaiting Compiler 1.5.4
        maven {
            url = uri("https://androidx.dev/storage/compose-compiler/repository")
            mavenContent {
                includeGroup("androidx.compose.compiler")
            }
        }
        google()
        mavenCentral()
    }
}

plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "0.7.0"
}

enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")

rootProject.name = "compose-shadow-alternative"

include(":androidApp")
include(":compose-boxshadow")
include(":compose-dropshadow")
