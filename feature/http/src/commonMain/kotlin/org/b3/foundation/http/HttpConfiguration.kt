package org.b3.foundation.http

import io.ktor.client.HttpClient
import io.ktor.client.HttpClientConfig
import io.ktor.client.engine.HttpClientEngineConfig
import io.ktor.client.engine.HttpClientEngineFactory
import io.ktor.server.application.Application
import io.ktor.server.engine.ApplicationEngine
import io.ktor.server.engine.ApplicationEngineFactory
import io.ktor.server.engine.EmbeddedServer
import io.ktor.server.engine.embeddedServer
import org.b3.foundation.annotation.B3Dsl

@B3Dsl
class HttpConfiguration {
    fun <E : HttpClientEngineConfig> client(
        engine: HttpClientEngineFactory<E>,
        configure: @B3Dsl HttpClientConfig<E>.() -> Unit = {},
    ) {
        check(clientFactory == null) {
            "HTTP client already configured"
        }

        clientFactory = {
            HttpClient(
                engineFactory = engine,
                block = configure,
            )
        }
    }

    fun <E : ApplicationEngine, C : ApplicationEngine.Configuration> server(
        engine: ApplicationEngineFactory<E, C>,
        port: Int = 8080,
        host: String = "0.0.0.0",
        configure: @B3Dsl suspend Application.() -> Unit = {},
    ) {
        check(serverFactory == null) {
            "HTTP server already configured"
        }

        serverFactory = {
            embeddedServer(
                factory = engine,
                port = port,
                host = host,
                module = configure,
            )
        }
    }

    internal fun createRuntime() = HttpRuntime(
        client = clientFactory?.invoke(),
        server = serverFactory?.invoke(),
    )

    private var clientFactory: (() -> HttpClient)? = null
    private var serverFactory: (() -> EmbeddedServer<*, *>)? = null
}
