package io.github.kubode.compose.shadow.buildlogic

import com.android.build.api.dsl.CommonExtension
import org.gradle.api.Plugin
import org.gradle.api.Project

class AndroidComposePlugin : Plugin<Project> {
    override fun apply(target: Project) = target.apply()
}

private fun Project.apply() {
    extensions.configure<CommonExtension<*, *, *, *, *>>("android") {
        buildFeatures {
            compose = true
            composeOptions {
                kotlinCompilerExtensionVersion = libs.version("androidx-compose-compiler")
            }
        }
    }
}
