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
import kotlinx.html.style
import kotlinx.html.title
import kotlinx.html.unsafe

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
                    style {
                        unsafe {
                            +"""
                                html, body {
                                    width: 100%;
                                    height: 100%;
                                    margin: 0;
                                    padding: 0;
                                }
                                
                                #${config.containerId} {
                                    width: 100%;
                                    height: 100%;
                                }
                            """.trimIndent()
                        }
                    }
                }

                body {
                    div {
                        id = config.containerId
                        attributes["data-b3-viewport"] = ""
                        attributes["data-b3-entrypoint"] = "org.b3.foundation.ui.wasm.ApplicationMainKt.main"
                    }
                    script { src = config.entryScript }
                }
            }
}
