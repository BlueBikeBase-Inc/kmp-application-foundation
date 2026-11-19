package org.b3.foundation.application

internal class FeatureRegistry {
    fun <T : Any> attach(
        key: FeatureKey<T>,
        instance: T,
    ) {
        check(key !in entries) { "Feature Key $key already attached to a ${instance::class.simpleName} instance" }

        entries[key] = instance

    }

    @Suppress("UNCHECKED_CAST")
    fun <T : Any> get(key: FeatureKey<T>): T =
        checkNotNull(entries[key]) { "${key.nane} is not attached" } as T

    fun <T : Any> getOrNull(key: FeatureKey<T>): T? {
        @Suppress("UNCHECKED_CAST")
        return entries[key] as T?
    }

    private val entries = mutableMapOf<FeatureKey<*>, Any>()
}
