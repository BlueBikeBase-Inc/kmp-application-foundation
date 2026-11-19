package org.b3.foundation.ui.view

import androidx.compose.runtime.Composable

interface ViewLayer : View {
    val child: View

    @Composable
    fun Apply(content: @Composable () -> Unit)

    @Composable
    override fun onRender() = Apply {
        child.onRender()
    }
}
