import org.jetbrains.kotlin.gradle.ExperimentalWasmDsl

plugins {
    alias(libs.plugins.kotlin.multiplatform)

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
            api(project(":ui"))
        }
    }
}

b3Web {
    title.set("Web UI")
    entryScript.set(webEntryScript)
}
