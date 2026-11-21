package org.b3.foundation.ui.runtime

import androidx.compose.runtime.Composable
import androidx.lifecycle.compose.LifecycleStartEffect
import org.b3.foundation.runtime.LifecycleOwner

@Composable
fun BindLifecycle(
    owner: LifecycleOwner,
) {
    LifecycleStartEffect(owner) {
        owner.start()
        onStopOrDispose { owner.stop() }
    }
}
