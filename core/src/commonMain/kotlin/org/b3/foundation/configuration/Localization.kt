package org.b3.foundation.configuration

import org.b3.foundation.application.Application
import org.b3.foundation.application.FeatureKey
import org.b3.foundation.application.Feature

object Localization : Feature<Application, LocalizationConfiguration> {
    val key = FeatureKey<LocalizationService>("Localization")

    override fun configuration(): LocalizationConfiguration =
        LocalizationConfiguration()

    override fun adapt(application: Application, configuration: LocalizationConfiguration) {
        application.attach(
            key = key,
            instance = LocalizationService(
                language = configuration.language,
            )
        )
    }
}
