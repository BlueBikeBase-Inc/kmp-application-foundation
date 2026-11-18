plugins {
    alias(libs.plugins.kotlin.jvm) apply false
    alias(libs.plugins.kotlin.multiplatform) apply false
    alias(libs.plugins.kotlin.plugin.serialization) apply false
    alias(libs.plugins.kotlin.plugin.compose) apply false

    alias(libs.plugins.jetbrains.compose) apply false
    alias(libs.plugins.android.kmp.library) apply false

    id("org.b3.foundation.plugin.web") version "0.1.0" apply false
}
