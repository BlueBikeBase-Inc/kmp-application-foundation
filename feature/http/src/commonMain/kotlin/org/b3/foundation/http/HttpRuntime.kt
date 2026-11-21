package org.b3.foundation.http

import io.ktor.client.HttpClient
import io.ktor.server.engine.EmbeddedServer

class HttpRuntime internal constructor(
    val client: HttpClient? = null,
    val server: EmbeddedServer<*, *>? = null,
)
