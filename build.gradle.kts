plugins {
    alias(libs.plugins.kotlin.multiplatform) apply false
    alias(libs.plugins.kotlin.plugin.serialization) apply false
    alias(libs.plugins.kotlin.plugin.compose) apply false

    alias(libs.plugins.jetbrains.compose) apply false
    alias(libs.plugins.android.kmp.library) apply false
}
