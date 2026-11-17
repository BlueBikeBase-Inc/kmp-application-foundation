package org.b3.foundation.wasm

import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.window.ComposeViewport
import org.b3.foundation.ui.runtime.Lifecycle
import org.b3.foundation.ui.Application
import org.b3.foundation.ui.LifecycleController

object ApplicationMain {
    @OptIn(ExperimentalComposeUiApi::class)
    fun main(
        application: Lifecycle = Application,
    ) = LifecycleController(application).run {
        create()

        ComposeViewport(
            viewportContainerId = VIEWPORT_CONTAINER_ID,
            content = application::Content,
        )

        start()
    }

    private const val VIEWPORT_CONTAINER_ID = "ui-root"
}
