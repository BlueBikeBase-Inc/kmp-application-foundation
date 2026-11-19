package org.b3.foundation.runtime

class LifecycleController(
    private val application: Lifecycle,
) {
    var state: LifecycleState = LifecycleState.INITIALIZED
        private set

    fun create() {
        check(state == LifecycleState.INITIALIZED)

        application.onCreate()
        state = LifecycleState.CREATED
    }

    fun start() {
        if (state == LifecycleState.CREATED || state == LifecycleState.STOPPED) {
            application.onStart()
            state = LifecycleState.STARTED
        }
    }

    fun stop() {
        if (state == LifecycleState.STARTED) {
            application.onStop()
            state = LifecycleState.STOPPED
        }
    }

    fun destroy() {
        if (state == LifecycleState.DESTROYED) return

        val wasCreated = state != LifecycleState.INITIALIZED

        try {
            stop()
        } finally {
            try {
                if (wasCreated) {
                    application.onDestroy()
                }
            } finally {
                state = LifecycleState.DESTROYED
            }
        }
    }
}
