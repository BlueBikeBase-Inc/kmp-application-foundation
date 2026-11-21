package org.b3.foundation.application

import org.b3.foundation.runtime.Lifecycle

abstract class Application : Lifecycle {
    override fun onCreate() {
        registry.participants
            .forEach { participant -> participant.onApplicationCreated() }
    }

    override fun onStart() {
        registry.participants
            .forEach { participant -> participant.onApplicationStarted() }
    }

    override fun onStop() {
        registry.participants
            .asReversed()
            .forEach { participant -> participant.onApplicationStopped() }
    }

    override fun onDestroy() {
        registry.participants
            .asReversed()
            .forEach { participant -> participant.onApplicationDestroyed() }
    }

    fun <T : Any> register(
        key: FeatureKey<T>,
        instance: T,
    ) {
        registry.register(key, instance)
    }

    fun <T : Any> get(key: FeatureKey<T>): T = registry.get(key)
    fun <T : Any> getOrNull(key: FeatureKey<T>): T? = registry.getOrNull(key)

    private val registry: FeatureRegistry = FeatureRegistry()
}
