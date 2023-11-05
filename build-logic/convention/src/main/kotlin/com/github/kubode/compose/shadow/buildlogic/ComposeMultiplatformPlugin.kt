package com.github.kubode.compose.shadow.buildlogic

import org.gradle.api.Plugin
import org.gradle.api.Project

class ComposeMultiplatformPlugin : Plugin<Project> {
    override fun apply(target: Project) = target.apply()
}

private fun Project.apply() {
}
