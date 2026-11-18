package org.b3.foundation.plugin.web

import org.gradle.api.Plugin
import org.gradle.api.Project
import kotlin.jvm.java


class B3WebPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        val extension = target.extensions.create(
            "b3Web",
            B3WebExtension::class.java,
        )

        extension.title.convention("B3 Application")
        extension.language.convention("ja")
        extension.entryScript.convention("${target.name}.js")

        target.tasks.register(
            "generateIndexHtml",
            GenerateTemplateTask::class.java,
        ) { task ->
            task.group = "b3"
            task.description = "Generates an index.html for Kotlin/Wasm."

            task.title.set(extension.title)
            task.language.set(extension.language)
            task.entryScript.set(extension.entryScript)

            task.outputDirectory.set(
                target.layout.buildDirectory.dir(
                    "generated/org/b3/foundation/web"
                )
            )
        }
    }
}
