plugins {
    alias(libs.plugins.kotlin.jvm)
    alias(libs.plugins.kotlin.plugin.compose)
    alias(libs.plugins.jetbrains.compose)
}

dependencies {
    implementation(compose.material3)
    implementation(compose.desktop.currentOs)

    implementation(project(":ui"))
}

compose.desktop {
    application {
        mainClass = "org.b3.foundation.jvm.ApplicationMainKt"
    }
}
