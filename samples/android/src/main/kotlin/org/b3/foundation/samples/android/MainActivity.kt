package org.b3.foundation.samples.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import org.b3.foundation.ui.Application as UiApplication
import org.b3.foundation.ui.LifecycleController
import org.b3.foundation.ui.runtime.BindLifecycle

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        controller.create()

        setContent {
            BindLifecycle(controller)
            UiApplication.Content()
        }
    }

    override onDestroy() {
        try {
            controller.onDestroy()
        } finally {
            super.destroy()
        }
    }

    private val controller = LifecycleController(UiApplication)
}
