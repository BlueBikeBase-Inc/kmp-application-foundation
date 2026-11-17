import org.jetbrains.kotlin.gradle.ExperimentalWasmDsl

plugins {
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.kotlin.plugin.compose)
    alias(libs.plugins.jetbrains.compose)
    alias(libs.plugins.android.kmp.library)
}

kotlin {
    @OptIn(ExperimentalWasmDsl::class)
    wasmJs { browser() }

    iosArm64()
    iosSimulatorArm64()

    jvm()
    android {
        namespace = "org.b3.foundation.ui"
        compileSdk = 37
        minSdk = 24
    }

    sourceSets {
        commonMain.dependencies {
            implementation(compose.runtime)
            implementation(compose.foundation)
            implementation(compose.material3)
            implementation(compose.materialIconsExtended)
            implementation(compose.ui)
            implementation(compose.components.resources)

            api(project(":core"))
        }
        wasmJsMain.dependencies {
            implementation(libs.kotlinx.browswer)
            implementation(libs.kotlinx.html.wasm.js)
        }
        wasmJsTest.dependencies {
            implementation(kotlin("test-wasm-js"))
        }
    }
}
