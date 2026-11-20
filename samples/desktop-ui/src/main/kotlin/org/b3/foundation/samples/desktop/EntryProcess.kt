package org.b3.foundation.samples.desktop

import androidx.compose.material3.Text
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable
import org.b3.foundation.application.apply
import org.b3.foundation.localization.Localization
import org.b3.foundation.localization.LocalizationState
import org.b3.foundation.ui.UI
import org.b3.foundation.ui.UiApplication
import org.b3.foundation.ui.jvm.ApplicationMain
import org.b3.foundation.ui.localization
import org.b3.foundation.ui.theme
import org.b3.foundation.ui.view.View

fun main(args: Array<String>) {
    UiApplication.configureView()
    ApplicationMain.main(args = args)
}

fun UiApplication.configureView() {
    apply(Localization)

    apply(UI) {
        theme(colorScheme = darkColorScheme())
        localization(language = LocalizationState.JA)

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
