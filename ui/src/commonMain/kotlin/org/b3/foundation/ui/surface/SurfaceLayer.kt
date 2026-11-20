package org.b3.foundation.ui.surface

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import org.b3.foundation.ui.view.View
import org.b3.foundation.ui.view.ViewLayer

class SurfaceLayer(
    override val child: View,
    private val configuration: SurfaceConfiguration,
) : ViewLayer {
    @Composable
    override fun Apply(content: @Composable (() -> Unit)) {
        val color = configuration.color
            ?: MaterialTheme.colorScheme.background

        Surface(
            modifier = Modifier.fillMaxSize(),
            color = color,
            contentColor = configuration.contentColor
                ?: contentColorFor(color),
            content = content,
        )
    }
}
