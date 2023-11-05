package com.github.kubode.compose.shadow.buildlogic

import com.android.build.api.dsl.CommonExtension
import org.gradle.api.Plugin
import org.gradle.api.Project

class AndroidCommonPlugin : Plugin<Project> {
    override fun apply(target: Project) = target.apply()
}

private fun Project.apply() {
    extensions.configure<CommonExtension<*, *, *, *, *>>("android") {
        compileSdk = 34
        defaultConfig {
            minSdk = 21
        }
    }
}
