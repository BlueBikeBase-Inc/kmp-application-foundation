package org.b3.foundation.wasm.template

import kotlinx.html.body
import kotlinx.html.div
import kotlinx.html.head
import kotlinx.html.html
import kotlinx.html.id
import kotlinx.html.lang
import kotlinx.html.meta
import kotlinx.html.stream.createHTML
import kotlinx.html.title

object IndexHtml {
    fun generate(config: WebPageConfig): String =
        "<!DOCTYPE html>\n" + createHTML(prettyPrint = true)
            .html {
                lang = config.language

                head {
                    meta { charset = "UTF-8" }
                    title { +config.title }
                }

                body {
                    div { id = "ui-root" }
                }
            }
}
