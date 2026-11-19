import org.jetbrains.kotlin.gradle.ExperimentalWasmDsl

plugins {
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.kotlin.plugin.compose)
    alias(libs.plugins.jetbrains.compose)

    id("org.b3.foundation.plugin.web")
}

val genHtmlTemplate = tasks.named("generateIndexHtml")
val webEntryScript = "app.js"

kotlin {
    @OptIn(ExperimentalWasmDsl::class)
    wasmJs {
        browser {
            commonWebpackConfig {
                outputFileName = webEntryScript
            }
        }
        binaries.executable()
    }

    sourceSets {
        wasmJsMain.dependencies {
            implementation(compose.runtime)
            implementation(compose.material3)
            implementation(compose.ui)

            implementation(project(":ui"))
        }
    }
}

b3Web {
    title.set("Web UI")
    entryScript.set(webEntryScript)
}
