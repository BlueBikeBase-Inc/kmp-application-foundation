package org.b3.foundation.ui

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import org.b3.foundation.ui.runtime.Lifecycle

object Application : Lifecycle {
    @Composable
    override fun Content() {
        Text("org.b3.foundation.ui.Application.Content()")
    }

    override fun onCreate() {
        println("org.b3.foundation.ui.Application.onCreate()")
    }

    override fun onStart() {
        println("org.b3.foundation.ui.Application.onStart()")
    }

    override fun onStop() {
        println("org.b3.foundation.ui.Application.onStop()")
    }

    override fun onDestroy() {
        println("org.b3.foundation.ui.Application.onDestroy()")
    }
}
