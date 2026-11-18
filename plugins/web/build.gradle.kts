plugins {
    alias(libs.plugins.kotlin.jvm)
    `java-gradle-plugin`
}

dependencies {
    implementation(libs.kotlinx.html)

    testImplementation(kotlin("test"))
}

gradlePlugin {
    plugins {
        create("b3Web") {
            id = "org.b3.foundation.plugin.web"
            implementationClass = "org.b3.foundation.plugin.web.B3WebPlugin"

            displayName = "B3 Web Plugin"
            description = "Generates HTML resources for B3 web applications."
        }
    }
}
