package org.b3.foundation.server

import org.b3.foundation.runtime.LifecycleController

object ApplicationMain {
    fun main(args: Array<String>) {
        val controller = LifecycleController(ServerApplication)

        try {
            controller.create()
        } finally {
            controller.destroy()
        }
    }
}
