package org.b3.foundation.jvm

import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.rememberWindowState
import org.b3.foundation.ui.Application
import org.b3.foundation.ui.LifecycleController
import org.b3.foundation.ui.runtime.BindLifecycle
import org.b3.foundation.ui.runtime.Lifecycle
import androidx.compose.ui.window.application

object ApplicationMain {
    @JvmStatic
    @JvmOverloads
    fun main(
        args: Array<String>,
        application: Lifecycle = Application,
    ) = LifecycleController(application).run {
        create()

        try {
            application {
                Window(
                    onCloseRequest = ::exitApplication,
                    title = "Foundation Desktop",
                    state = rememberWindowState(
                        width = 1280.dp,
                        height = 800.dp,
                    ),
                    content = {
                        BindLifecycle(this@run)
                        application.Content()
                    },
                )
            }
        } finally {
            destroy()
        }
    }
}
