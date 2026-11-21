import org.jetbrains.kotlin.gradle.ExperimentalWasmDsl

plugins {
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.android.kmp.library)
}

kotlin {
    @OptIn(ExperimentalWasmDsl::class)
    wasmJs { browser() }

    iosArm64()
    iosSimulatorArm64()

    jvm()

    android {
        namespace = "org.b3.foundation.feature.localization"
        compileSdk = 37
        minSdk = 24
    }

    sourceSets {
        commonMain.dependencies {
            api(libs.ktor.client.core)
            api(libs.ktor.server.core)
            api(libs.ktor.server.cio)

            api(project(":core"))
        }
        jvmMain.dependencies {
            implementation(libs.ktor.client.cio)
        }

        androidMain.dependencies {
            implementation(libs.ktor.client.okhttp)
        }

        iosMain.dependencies {
            implementation(libs.ktor.client.darwin)
        }

        wasmJsMain.dependencies {
            implementation(libs.ktor.client.js)
        }

        commonTest.dependencies {
            implementation(libs.ktor.client.mock)
        }
    }
}
