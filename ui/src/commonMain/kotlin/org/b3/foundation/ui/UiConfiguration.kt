package org.b3.foundation.ui

import org.b3.foundation.ui.view.View

class UiConfiguration {
    fun root(factory: () -> View) {
        check(rootFactory == null) {
            "Root View is already attached to a View factory"
        }

        rootFactory = factory
    }

    fun wrapRoot(factory: (View) -> View) {
        rootLayers += factory
    }

    internal fun createRoot(): View {
        val root = checkNotNull(rootFactory) {
            "Root View is not Configured"
        }.invoke()

        return rootLayers.asReversed()
            .fold(root) { child, wrap -> wrap.invoke(child) }
    }

    private var rootFactory: (() -> View)? = null
    private val rootLayers = mutableListOf<(View) -> View>()
}
