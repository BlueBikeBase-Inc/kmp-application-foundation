package org.b3.foundation.ui

import androidx.compose.material3.ColorScheme
import org.b3.foundation.application.apply
import org.b3.foundation.configuration.Localization
import org.b3.foundation.configuration.LocalizationState
import org.b3.foundation.ui.localization.LocalizationLayer
import org.b3.foundation.ui.theme.MaterialThemeLayer

fun UiConfiguration.theme(colorScheme: ColorScheme) {
    wrapRoot { child ->
        MaterialThemeLayer(
            child = child,
            colorScheme = colorScheme,
        )
    }
}

fun UiConfiguration.localization(
    language: LocalizationState? = null,
) {
    wrapRoot { child ->
        val service = UiApplication.getOrNull(Localization.key)
            ?: run {
                UiApplication.apply(Localization)
                UiApplication.get(Localization.key)
            }

        LocalizationLayer(
            child = child,
            localization = language ?: service.language,
        )
    }
}
