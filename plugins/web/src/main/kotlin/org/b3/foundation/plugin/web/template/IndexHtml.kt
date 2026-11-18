package org.b3.foundation.plugin.web.template

import kotlinx.html.body
import kotlinx.html.div
import kotlinx.html.head
import kotlinx.html.html
import kotlinx.html.id
import kotlinx.html.lang
import kotlinx.html.meta
import kotlinx.html.script
import kotlinx.html.stream.createHTML
import kotlinx.html.title

object IndexHtml {
    fun generate(config: WebPageConfig): String =
        "<!DOCTYPE html>\n" + createHTML(prettyPrint = true)
            .html {
                lang = config.language

                head {
                    meta { charset = "UTF-8" }
                    meta {
                        name = "viewport"
                        content = "width=device-width, initial-scale=1.0"
                    }
                    title { +config.title }
                }

                body {
                    div { id = "ui-root" }
                    script { src = config.entryScript }
                }
            }
}
