package org.b3.foundation.application

import org.b3.foundation.runtime.Lifecycle

abstract class Application : Lifecycle {
    override fun onCreate() {
        println("org.b3.foundation.application.Application.onCreate()")
    }

    override fun onStart() {
        println("org.b3.foundation.application.Application.onStart()")
    }

    override fun onStop() {
        println("org.b3.foundation.application.Application.onStop()")
    }

    override fun onDestroy() {
        println("org.b3.foundation.application.Application.onDestroy()")
    }
}
