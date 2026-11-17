package org.b3.foundation.wasm.template

data class WebPageConfig(
    val title: String,
    val language: String = "ja",
    val entryScript: String = "ui.js",
)
