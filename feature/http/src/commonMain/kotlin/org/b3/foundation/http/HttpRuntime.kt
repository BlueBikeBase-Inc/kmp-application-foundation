package org.b3.foundation.http

import io.ktor.client.HttpClient
import io.ktor.server.engine.EmbeddedServer
import org.b3.foundation.application.ApplicationLifecycleParticipant

class HttpRuntime internal constructor(
    val client: HttpClient? = null,
    val server: EmbeddedServer<*, *>? = null,
) : ApplicationLifecycleParticipant {
    override fun onApplicationCreated() {
        println("HttpRuntime#onApplicationCreated")
    }

    override fun onApplicationStarted() {
        println("HttpRuntime#onApplicationStarted")
        server?.start(wait = false)
    }

    override fun onApplicationStopped() {
        println("HttpRuntime#onApplicationStopped")
        server?.stop(
            gracePeriodMillis = 1_000,
            timeoutMillis = 5_000,
        )
    }

    override fun onApplicationDestroyed() {
        println("HttpRuntime#onApplicationDestroyed")
        client?.close()
    }
}
