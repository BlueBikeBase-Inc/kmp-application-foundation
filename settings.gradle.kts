pluginManagement {
    includeBuild("plugins/web")

    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}

plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "1.0.0"
}

dependencyResolutionManagement {
    @Suppress("UnstableApiUsage")
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "foundation"

include(
    ":core",
    ":ui",
    ":server",
    ":feature:localization",
    ":feature:logging",
    ":feature:http",

    ":samples:web-ui",
    ":samples:desktop-ui",
    ":samples:android",
    ":samples:http-server",
)
