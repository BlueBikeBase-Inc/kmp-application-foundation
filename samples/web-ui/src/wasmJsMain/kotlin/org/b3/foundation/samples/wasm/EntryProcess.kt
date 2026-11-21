package org.b3.foundation.samples.wasm

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import io.ktor.client.engine.js.*
import org.b3.foundation.application.install
import org.b3.foundation.http.HTTP
import org.b3.foundation.localization.Localization
import org.b3.foundation.localization.LocalizationState
import org.b3.foundation.ui.*
import org.b3.foundation.ui.container.BottomBarContainer
import org.b3.foundation.ui.container.BoxContainer
import org.b3.foundation.ui.container.ScaffoldContainer
import org.b3.foundation.ui.container.TopBarContainer
import org.b3.foundation.ui.view.View
import org.b3.foundation.ui.wasm.ApplicationMain

fun main() {
    UiApplication.configureView()
    ApplicationMain.main()
}

fun UiApplication.configureView() {
    install(Localization)
    install(HTTP) {
        client(Js) {
            engine {
            }
        }
    }
    install(UI) {
        localization(language = LocalizationState.JA)
        theme { }
        surface {
            modifier = Modifier
                .fillMaxSize()

            isCentered = true
        }

        view {
            fun textView(value: String): View {
                val child = object : View {
                    @Composable
                    override fun onRender() {
                        Text(value)
                    }
                }

                return BoxContainer(
                    children = listOf(child),
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp),
                    contentAlignment = Alignment.Center,
                )
            }

            val content = "WasmJs UI configuration"

            val topBar = TopBarContainer(
                children = listOf(textView("$content TopBar")),
            )
            val bottomBar = BottomBarContainer(
                children = listOf(textView("$content BottomBar")),
            )
            val body = BoxContainer(
                children = listOf(textView(content)),
            )

            ScaffoldContainer(
                topBar = topBar,
                bottomBar = bottomBar,
                body = body,
            )
        }
    }
}
