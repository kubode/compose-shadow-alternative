package com.github.kubode.compose.shadow.buildlogic

import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.publish.PublishingExtension

class PublishPlugin : Plugin<Project> {
    override fun apply(target: Project) = target.apply()
}

private fun Project.apply() {
    plugins.apply("maven-publish")
    extensions.configure<PublishingExtension>("publishing") {
        repositories {
            maven {
                name = "GitHubPackages"
                url = uri("https://maven.pkg.github.com/kubode/compose-shadow-alternative")
                credentials {
                    username = "unused"
                    password = properties["GITHUB_TOKEN"].toString()
                }
            }
        }
    }
}
