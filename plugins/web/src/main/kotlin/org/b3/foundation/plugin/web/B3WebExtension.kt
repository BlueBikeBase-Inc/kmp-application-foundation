package org.b3.foundation.plugin.web

import org.gradle.api.provider.Property

abstract class B3WebExtension {
    abstract val title: Property<String>
    abstract val language: Property<String>
    abstract val entryScript: Property<String>
}
