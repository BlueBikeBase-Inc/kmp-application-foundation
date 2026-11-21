package org.b3.foundation.ui.jvm

import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import androidx.compose.ui.window.rememberWindowState
import org.b3.foundation.runtime.LifecycleController
import org.b3.foundation.ui.UiApplication
import org.b3.foundation.ui.runtime.BindLifecycle

object ApplicationMain {
    @JvmStatic
    fun main(args: Array<String>) {
        val controller = LifecycleController(UiApplication)

        try {
            controller.create()

            application(exitProcessOnExit = false) {
                Window(
                    onCloseRequest = ::exitApplication,
                    title = "Foundation Desktop",
                    state = rememberWindowState(
                        width = 1280.dp,
                        height = 800.dp,
                    ),
                    content = {
                        BindLifecycle(controller)
                        UiApplication.Content()
                    },
                )
            }
        } finally {
            controller.destroy()
        }
    }
}
