package org.b3.foundation.ui

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import org.b3.foundation.ui.runtime.Lifecycle

object UiApplication : Lifecycle {
    @Composable
    override fun Content() {
        Text("WasmJsUiApplication.Content")
    }

    override fun onCreate() {
        println("WasmJsUiApplication.onCreate()")
    }

    override fun onStart() {
        println("WasmJsUiApplication.onStart()")
    }

    override fun onStop() {
        println("WasmJsUiApplication.onStop()")
    }

    override fun onDestroy() {
        println("WasmJsUiApplication.onDestroy()")
    }
}
