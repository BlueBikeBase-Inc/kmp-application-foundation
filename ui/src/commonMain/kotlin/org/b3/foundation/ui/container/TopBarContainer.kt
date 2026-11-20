package org.b3.foundation.ui.container

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import org.b3.foundation.ui.view.View

class TopBarContainer(
    override val children: List<View>,
) : Container() {
    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    override fun Apply(content: @Composable (() -> Unit)) {
        TopAppBar(
            title = { content() },
        )
    }
}
