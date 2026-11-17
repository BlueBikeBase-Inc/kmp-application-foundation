package org.b3.foundation.jvm

import org.b3.foundation.ui.Application
import org.b3.foundation.ui.runtime.Lifecycle

object ApplicationMain {
    @JvmStatic
    @JvmOverloads
    fun main(
        args: Array<String>,
        application: Lifecycle = Application,
    ) = application.run {
        onCreate()

        try {
            onStart()

            try {
            } finally {
                onStop()
            }
        } finally {
            onDestroy()
        }
    }
}
