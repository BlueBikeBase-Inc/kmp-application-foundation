package org.b3.foundation.samples.desktop

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import org.b3.foundation.application.apply
import org.b3.foundation.localization.Localization
import org.b3.foundation.localization.LocalizationState
import org.b3.foundation.ui.UI
import org.b3.foundation.ui.UiApplication
import org.b3.foundation.ui.jvm.ApplicationMain
import org.b3.foundation.ui.localization
import org.b3.foundation.ui.surface
import org.b3.foundation.ui.theme
import org.b3.foundation.ui.view.View

fun main(args: Array<String>) {
    UiApplication.configureView()
    ApplicationMain.main(args = args)
}

fun UiApplication.configureView() {
    apply(Localization)

    apply(UI) {
        localization(language = LocalizationState.JA)
        theme()
        surface {
            modifier = Modifier
                .fillMaxSize()

            contentColor = Color.Cyan

            isCentered = true
        }

        view {
            object : View {
                @Composable
                override fun onRender() {
                    Text("Desktop UI configuration")
                }
            }
        }
    }
}
