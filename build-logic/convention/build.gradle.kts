plugins {
    `kotlin-dsl`
}

gradlePlugin {
    plugins {
        register("kotlinCommon") {
            id = "io.github.kubode.compose.shadow.kotlin.common"
            implementationClass =
                "io.github.kubode.compose.shadow.buildlogic.KotlinCommonPlugin"
        }
        register("composeMultiplatform") {
            id = "io.github.kubode.compose.shadow.compose.multiplatform"
            implementationClass =
                "io.github.kubode.compose.shadow.buildlogic.ComposeMultiplatformPlugin"
        }
        register("androidCommon") {
            id = "io.github.kubode.compose.shadow.android.common"
            implementationClass =
                "io.github.kubode.compose.shadow.buildlogic.AndroidCommonPlugin"
        }
        register("androidCompose") {
            id = "io.github.kubode.compose.shadow.android.compose"
            implementationClass =
                "io.github.kubode.compose.shadow.buildlogic.AndroidComposePlugin"
        }
    }
}

dependencies {
    compileOnly(libs.kotlin.gradle.plugin)
    compileOnly(libs.compose.multiplatform.gradle.plugin)
    compileOnly(libs.android.gradle.plugin)
}
