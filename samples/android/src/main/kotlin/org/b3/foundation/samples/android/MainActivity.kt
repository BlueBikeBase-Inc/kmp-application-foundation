package org.b3.foundation.samples.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import org.b3.foundation.ui.Application
import org.b3.foundation.ui.LifecycleController
import org.b3.foundation.ui.runtime.BindLifecycle

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        controller.create()

        setContent {
            BindLifecycle(controller)
            Application.Content()
        }
    }

    override onDestroy() = try {
        super.onDestroy()
    } finally {
        controller.destroy()
    }

    private val controller = LifecycleController(Application)
}
