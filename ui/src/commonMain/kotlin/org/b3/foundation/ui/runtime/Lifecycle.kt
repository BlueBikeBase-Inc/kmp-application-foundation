package org.b3.foundation.ui.runtime

import androidx.compose.runtime.Composable
import org.b3.foundation.runtime.Creatable
import org.b3.foundation.runtime.Destroyable
import org.b3.foundation.runtime.Startable
import org.b3.foundation.runtime.Stoppable

interface Lifecycle :
    Creatable,
    Startable,
    Stoppable,
    Destroyable
{ @Composable fun Content() }
