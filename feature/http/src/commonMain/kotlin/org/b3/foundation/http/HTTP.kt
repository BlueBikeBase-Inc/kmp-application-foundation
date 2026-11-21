package org.b3.foundation.http

import org.b3.foundation.application.Application
import org.b3.foundation.application.Feature
import org.b3.foundation.application.FeatureKey

object HTTP : Feature<Application, HttpConfiguration, HttpRuntime> {
    override val key: FeatureKey<HttpRuntime> = FeatureKey("HTTP")

    override fun configuration(): HttpConfiguration {
        TODO("Not yet implemented")
    }

    override fun adapt(application: Application, configuration: HttpConfiguration) {
        TODO("Not yet implemented")
    }
}
