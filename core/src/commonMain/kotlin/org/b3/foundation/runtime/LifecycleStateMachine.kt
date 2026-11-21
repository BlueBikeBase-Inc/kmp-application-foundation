package org.b3.foundation.runtime

internal class LifecycleStateMachine(
    private val lifecycle: Lifecycle,
) : LifecycleOperations {
    var state: LifecycleState = LifecycleState.INITIALIZED
        private set

    override fun create() {
        check(state == LifecycleState.INITIALIZED)

        lifecycle.onCreate()
        state = LifecycleState.CREATED
    }

    override fun start() {
        if (state != LifecycleState.CREATED && state != LifecycleState.STOPPED) return

        lifecycle.onStart()
        state = LifecycleState.STARTED
    }

    override fun stop() {
        if (state != LifecycleState.STARTED) return

        lifecycle.onStop()
        state = LifecycleState.STOPPED
    }

    override fun destroy() {
        if (state == LifecycleState.DESTROYED) return

        val wasCreated = state != LifecycleState.INITIALIZED

        try {
            stop()
        } finally {
            try {
                if (wasCreated) {
                    lifecycle.onDestroy()
                }
            } finally {
                state = LifecycleState.DESTROYED
            }
        }
    }
}
