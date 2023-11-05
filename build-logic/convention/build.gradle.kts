plugins {
    `kotlin-dsl`
}

gradlePlugin {
    plugins {
        register("kotlinCommon") {
            id = "com.github.kubode.compose.shadow.kotlin.common"
            implementationClass =
                "com.github.kubode.compose.shadow.buildlogic.KotlinCommonPlugin"
        }
        register("composeMultiplatform") {
            id = "com.github.kubode.compose.shadow.compose.multiplatform"
            implementationClass =
                "com.github.kubode.compose.shadow.buildlogic.ComposeMultiplatformPlugin"
        }
        register("androidCommon") {
            id = "com.github.kubode.compose.shadow.android.common"
            implementationClass =
                "com.github.kubode.compose.shadow.buildlogic.AndroidCommonPlugin"
        }
        register("androidCompose") {
            id = "com.github.kubode.compose.shadow.android.compose"
            implementationClass =
                "com.github.kubode.compose.shadow.buildlogic.AndroidComposePlugin"
        }
        register("publish") {
            id = "com.github.kubode.compose.shadow.publish"
            implementationClass =
                "com.github.kubode.compose.shadow.buildlogic.PublishPlugin"
        }
    }
}

dependencies {
    compileOnly(libs.kotlin.gradle.plugin)
    compileOnly(libs.compose.multiplatform.gradle.plugin)
    compileOnly(libs.android.gradle.plugin)
}
