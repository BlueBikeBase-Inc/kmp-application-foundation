package org.b3.foundation.runtime

class LifecycleController private constructor(
    private val machine: LifecycleStateMachine,
) : LifecycleOperations by machine {
    constructor(lifecycle: Lifecycle) : this(LifecycleStateMachine(lifecycle))

    val state: LifecycleState
        get() = machine.state
}
