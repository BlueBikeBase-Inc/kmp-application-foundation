package org.b3.foundation.ui

import org.b3.foundation.ui.view.View

class UiConfiguration {
    fun root(factory: () -> View) {
        check(rootFactory == null) {
            "Root View is already attached to a View factory"
        }

        rootFactory = factory
    }

    internal fun createRoot(): View =
        checkNotNull(rootFactory) {
            "Root View is not Configured"
        }.invoke()

    private var rootFactory: (() -> View)? = null
}
