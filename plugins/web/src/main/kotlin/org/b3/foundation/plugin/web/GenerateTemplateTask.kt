package org.b3.foundation.plugin.web

import org.b3.foundation.plugin.web.template.IndexHtml
import org.b3.foundation.plugin.web.template.WebPageConfig
import org.gradle.api.DefaultTask
import org.gradle.api.file.DirectoryProperty
import org.gradle.api.provider.Property
import org.gradle.api.tasks.CacheableTask
import org.gradle.api.tasks.Input
import org.gradle.api.tasks.OutputDirectory
import org.gradle.api.tasks.TaskAction

@CacheableTask
abstract class GenerateTemplateTask : DefaultTask() {
    @get:Input
    abstract val title: Property<String>

    @get:Input
    abstract val language: Property<String>

    @get:Input
    abstract val containerId: Property<String>

    @get:Input
    abstract val entryScript: Property<String>

    @get:OutputDirectory
    abstract val outputDirectory: DirectoryProperty

    @TaskAction
    fun generate() {
        val config = WebPageConfig(
            title = title.get(),
            language = language.get(),
            containerId = containerId.get(),
            entryScript = entryScript.get(),
        )

        val output = outputDirectory
            .file("index.html")
            .get()
            .asFile

        output.parentFile.mkdirs()

        output.writeText(
            IndexHtml.generate(config),
            Charsets.UTF_8,
        )
    }
}
