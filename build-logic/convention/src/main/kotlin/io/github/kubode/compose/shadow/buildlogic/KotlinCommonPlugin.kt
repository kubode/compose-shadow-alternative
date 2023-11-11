package io.github.kubode.compose.shadow.buildlogic

import org.gradle.api.Plugin
import org.gradle.api.Project
import org.jetbrains.kotlin.gradle.dsl.KotlinProjectExtension

class KotlinCommonPlugin : Plugin<Project> {
    override fun apply(target: Project) = target.apply()
}

private fun Project.apply() {
    extensions.configure<KotlinProjectExtension>("kotlin") {
        jvmToolchain(19)
    }
}
