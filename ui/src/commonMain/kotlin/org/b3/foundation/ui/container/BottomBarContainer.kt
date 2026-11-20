package org.b3.foundation.ui.container

import androidx.compose.material3.BottomAppBar
import androidx.compose.runtime.Composable
import org.b3.foundation.ui.view.View

class BottomBarContainer(
    override val children: List<View>,
) : Container() {
    @Composable
    override fun Apply(content: @Composable (() -> Unit)) {
        BottomAppBar(
            content = { content() },
        )
    }
}
