package org.b3.foundation.wasm

import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.window.ComposeViewport
import org.b3.foundation.ui.runtime.Lifecycle
import org.b3.foundation.ui.UiApplication

object ApplicationMain {
    @OptIn(ExperimentalComposeUiApi::class)
    fun main(
        application: Lifecycle = UiApplication,
    ) = application.run {
        onCreate()
        ComposeViewport(
            viewportContainerId = VIEWPORT_CONTAINER_ID,
            content = ::Content,
        )
        onStart()
    }

    private const val VIEWPORT_CONTAINER_ID = "ui-root"
}
