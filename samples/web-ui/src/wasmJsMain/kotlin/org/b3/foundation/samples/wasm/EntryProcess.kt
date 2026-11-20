package org.b3.foundation.samples.wasm

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import org.b3.foundation.application.apply
import org.b3.foundation.localization.Localization
import org.b3.foundation.localization.LocalizationState
import org.b3.foundation.ui.*
import org.b3.foundation.ui.view.View
import org.b3.foundation.ui.wasm.ApplicationMain

fun main() {
    UiApplication.configureView()
    ApplicationMain.main()
}

fun UiApplication.configureView() {
    apply(Localization)

    apply(UI) {
        localization(language = LocalizationState.JA)
        theme(colorScheme = darkColorScheme())
        surface {
            modifier = Modifier
                .fillMaxSize()

            color = Color.Black
            contentColor = Color.Cyan

            isCentered = true
        }

        view {
            object : View {
                @Composable
                override fun onRender() {
                    Text("WasmJs UI configuration")
                }
            }
        }
    }
}
