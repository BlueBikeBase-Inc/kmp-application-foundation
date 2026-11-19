package org.b3.foundation.samples.desktop

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import org.b3.foundation.application.apply
import org.b3.foundation.ui.UI
import org.b3.foundation.ui.UiApplication
import org.b3.foundation.ui.jvm.ApplicationMain
import org.b3.foundation.ui.view.View

fun main(args: Array<String>) {
    UiApplication.configureView()
    ApplicationMain.main(args = args)
}

fun UiApplication.configureView() {
    apply(UI) {
        root {
            object : View {
                @Composable
                override fun onRender() {
                    Text("Desktop UI configuration")
                }
            }
        }
    }
}
