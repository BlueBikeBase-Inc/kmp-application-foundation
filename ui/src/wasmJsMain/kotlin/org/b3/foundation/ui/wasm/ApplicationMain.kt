package org.b3.foundation.ui.wasm

import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.window.ComposeViewport
import org.b3.foundation.ui.Application
import org.b3.foundation.runtime.LifecycleController
import org.b3.foundation.ui.runtime.BindLifecycle

object ApplicationMain {
    @OptIn(ExperimentalComposeUiApi::class)
    fun main(
        application: Application = Application,
    ) = LifecycleController(application).run {
        create()

        ComposeViewport(
            viewportContainerId = VIEWPORT_CONTAINER_ID,
            content = {
                BindLifecycle(this@run)
                application.Content()
            },
        )
    }

    private const val VIEWPORT_CONTAINER_ID = "ui-root"
}
