package org.b3.foundation.plugin.web.template

data class WebPageConfig(
    val title: String,
    val language: String = "ja",
    val entryScript: String = "ui.js",
)
