package org.b3.foundation.ui.jvm

import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import androidx.compose.ui.window.rememberWindowState
import org.b3.foundation.runtime.LifecycleOwner
import org.b3.foundation.ui.UiApplication
import org.b3.foundation.ui.runtime.BindLifecycle

object ApplicationMain {
    @JvmStatic
    fun main(args: Array<String>) {
        val owner = LifecycleOwner(UiApplication)

        try {
            owner.create()

            application(exitProcessOnExit = false) {
                Window(
                    onCloseRequest = ::exitApplication,
                    title = "Foundation Desktop",
                    state = rememberWindowState(
                        width = 1280.dp,
                        height = 800.dp,
                    ),
                    content = {
                        BindLifecycle(owner)
                        UiApplication.Content()
                    },
                )
            }
        } finally {
            owner.destroy()
        }
    }
}
