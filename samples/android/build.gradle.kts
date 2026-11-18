plugins {
    alias(libs.plugins.kotlin.plugin.compose)

    id("com.android.application")
}

android {
    namespace = "org.b3.foundation.samples.android"
    compileSdk = 37

    defaultConfig {
        applicationId = "com.b3.foundation.samples.android"
        minSdk = 24
        targetSdk = 37

        versionCode = 1
        versionName = "1.0"
    }

    buildFeatures {
        compose = true
    }
}

dependencies {
    implementation(libs.androidx.activity.compose)

    implementation(project(":ui"))
}
