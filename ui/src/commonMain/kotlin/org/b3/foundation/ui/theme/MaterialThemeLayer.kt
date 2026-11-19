package org.b3.foundation.ui.theme

import androidx.compose.material3.ColorScheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import org.b3.foundation.ui.view.View
import org.b3.foundation.ui.view.ViewLayer

class MaterialThemeLayer(
    override val child: View,
    private val colorScheme: ColorScheme,
) : ViewLayer {
    @Composable
    override fun Apply(content: @Composable (() -> Unit)) =
        MaterialTheme(
            colorScheme = colorScheme,
            content = content,
        )
}
