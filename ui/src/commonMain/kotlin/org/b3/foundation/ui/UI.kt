package org.b3.foundation.ui

import org.b3.foundation.application.Feature

object UI : Feature<UiApplication, UiConfiguration> {
    override fun configuration(): UiConfiguration =
        UiConfiguration()

    override fun adapt(
        application: UiApplication,
        configuration: UiConfiguration
    ) {
        application.attach(
            configuration.createRoot()
        )
    }
}
