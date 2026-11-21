import org.jetbrains.kotlin.gradle.ExperimentalWasmDsl

plugins {
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.kotlin.plugin.compose)
    alias(libs.plugins.jetbrains.compose)

    id("org.b3.foundation.plugin.web")
}

val genHtmlTemplate = tasks.named("generateIndexHtml")
val webEntryScript = "sample-app.js"

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

            implementation(libs.ktor.client.js)

            implementation(project(":ui"))
            implementation(project(":feature:http"))
        }
    }
}

b3Web {
    title.set("Sample Web UI")
    containerId.set("sample-ui-root")
    entryScript.set(webEntryScript)
}
