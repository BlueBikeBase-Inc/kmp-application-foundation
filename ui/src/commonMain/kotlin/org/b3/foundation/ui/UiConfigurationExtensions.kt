package org.b3.foundation.ui

import androidx.compose.material3.ColorScheme
import org.b3.foundation.localization.Localization
import org.b3.foundation.localization.LocalizationState
import org.b3.foundation.ui.localization.LocalizationLayer
import org.b3.foundation.ui.theme.MaterialThemeLayer
import org.b3.foundation.ui.view.ViewHierarchy

fun UiConfiguration.theme(colorScheme: ColorScheme) {
    layer(ViewHierarchy.THEME) { child ->
        MaterialThemeLayer(
            child = child,
            colorScheme = colorScheme,
        )
    }
}

fun UiConfiguration.localization(
    language: LocalizationState? = null,
) {
    layer(ViewHierarchy.LOCALIZATION) { child ->
        val service = UiApplication.getOrNull(Localization.key)

        LocalizationLayer(
            child = child,
            localization = language
                ?: service?.language
                ?: LocalizationState.Default,
        )
    }
}
