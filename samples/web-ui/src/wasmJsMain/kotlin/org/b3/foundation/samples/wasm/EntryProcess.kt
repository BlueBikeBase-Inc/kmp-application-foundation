package org.b3.foundation.samples.wasm

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import org.b3.foundation.application.apply
import org.b3.foundation.ui.UI
import org.b3.foundation.ui.UiApplication
import org.b3.foundation.ui.view.View
import org.b3.foundation.ui.wasm.ApplicationMain

fun main() {
    UiApplication.configureView()
    ApplicationMain.main()
}

fun UiApplication.configureView() {
    apply(UI) {
        root {
            object : View {
                @Composable
                override fun onRender() {
                    Text("WasmJs UI configuration")
                }
            }
        }
    }
}
