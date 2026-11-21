package org.b3.foundation.server

import org.b3.foundation.application.Application

object ServerApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        println("org.b3.foundation.server.ServerApplication.onCreate()")
    }

    override fun onStart() {
        super.onStart()
        println("org.b3.foundation.server.ServerApplication.onStart()")
    }

    override fun onStop() {
        super.onStop()
        println("org.b3.foundation.server.ServerApplication.onStop()")
    }

    override fun onDestroy() {
        super.onDestroy()
        println("org.b3.foundation.server.ServerApplication.onDestroy()")
    }
}
