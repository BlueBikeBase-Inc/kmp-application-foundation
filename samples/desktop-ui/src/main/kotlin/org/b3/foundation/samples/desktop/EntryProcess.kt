package org.b3.foundation.samples.desktop

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.b3.foundation.application.apply
import org.b3.foundation.localization.Localization
import org.b3.foundation.localization.LocalizationState
import org.b3.foundation.ui.*
import org.b3.foundation.ui.container.BottomBarContainer
import org.b3.foundation.ui.container.BoxContainer
import org.b3.foundation.ui.container.ScaffoldContainer
import org.b3.foundation.ui.container.TopBarContainer
import org.b3.foundation.ui.jvm.ApplicationMain
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
                //.fillMaxSize()

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

            val content = "Desktop UI configuration"

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
