package org.b3.foundation.ui.wasm

import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.window.ComposeViewport
import org.b3.foundation.runtime.LifecycleOwner
import org.b3.foundation.ui.UiApplication
import org.b3.foundation.ui.runtime.BindLifecycle
import org.b3.foundation.ui.wasm.util.findViewportContainerId

object ApplicationMain {
    @OptIn(ExperimentalComposeUiApi::class)
    fun main() {
        val containerId = checkNotNull(findViewportContainerId()) {
            "B3 viewport container is not found"
        }

        val owner = LifecycleOwner(UiApplication)
        owner.create()

        ComposeViewport(
            viewportContainerId = containerId,
            content = {
                BindLifecycle(owner)
                UiApplication.Content()
            },
        )
    }
}
