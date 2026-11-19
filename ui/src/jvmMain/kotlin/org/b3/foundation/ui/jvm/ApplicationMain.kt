package org.b3.foundation.ui.jvm

import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.rememberWindowState
import org.b3.foundation.ui.Application
import org.b3.foundation.runtime.LifecycleController
import org.b3.foundation.ui.runtime.BindLifecycle
import androidx.compose.ui.window.application

object ApplicationMain {
    @JvmStatic
    @JvmOverloads
    fun main(
        args: Array<String>,
        application: Application = Application,
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
