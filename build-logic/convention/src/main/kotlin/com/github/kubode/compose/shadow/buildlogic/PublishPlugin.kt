package com.github.kubode.compose.shadow.buildlogic

import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.publish.PublishingExtension
import org.gradle.api.publish.maven.MavenPublication
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.getValue
import org.gradle.kotlin.dsl.provideDelegate
import org.gradle.kotlin.dsl.register
import org.gradle.plugins.signing.SigningExtension

class PublishPlugin : Plugin<Project> {
    override fun apply(target: Project) = target.apply()
}

private fun Project.apply() {
    plugins.apply("maven-publish")
    plugins.apply("signing")
    val publishing: PublishingExtension by extensions
    with(publishing) {
        publications {
            register<MavenPublication>("maven") {
                pom {
                    name.set("Compose Shadow Alternative")
                    description.set("Alternative implementation of shadow for Compose.")
                    url.set("https://github.com/kubode/compose-shadow-alternative")
                    licenses {
                        license {
                            name.set("The Apache License, Version 2.0")
                            url.set("http://www.apache.org/licenses/LICENSE-2.0.txt")
                        }
                    }
                    developers {
                        developer {
                            name.set("Masatoshi Kubode")
                            email.set("swi.masatoshi@gmail.com")
                        }
                    }
                    scm {
                        connection.set("scm:git:git://github.com/kubode/compose-shadow-alternative.git")
                        developerConnection.set("scm:git:git://github.com/kubode/compose-shadow-alternative.git")
                        url.set("https://github.com/kubode/compose-shadow-alternative")
                    }
                }
            }
        }

        repositories {
            maven {
                val releasesRepoUrl =
                    uri("https://oss.sonatype.org/service/local/staging/deploy/maven2/")
                val snapshotsRepoUrl =
                    uri("https://oss.sonatype.org/content/repositories/snapshots/")
                val ossrhUsername: String by project
                val ossrhPassword: String by project

                url = if (version.toString().endsWith("SNAPSHOT")) {
                    snapshotsRepoUrl
                } else {
                    releasesRepoUrl
                }

                credentials {
                    username = ossrhUsername
                    password = ossrhPassword
                }
            }
        }
    }

    extensions.configure<SigningExtension> {
        sign(publishing.publications)
    }
}
