package org.b3.foundation.ui

import androidx.compose.runtime.Composable
import org.b3.foundation.application.Application
import org.b3.foundation.ui.view.View

object UiApplication : Application() {
    val view: View
        get() = checkNotNull(rootView) { "UI is not configured" }

    @Composable
    fun Content() {
        view.onRender()
    }

    override fun onCreate() {
        super.onCreate()
        println("org.b3.foundation.ui.UiApplication.onCreate()")
    }

    override fun onStart() {
        super.onStart()
        println("org.b3.foundation.ui.UiApplication.onStart()")
    }

    override fun onStop() {
        super.onStop()
        println("org.b3.foundation.ui.UiApplication.onStop()")
    }

    override fun onDestroy() {
        super.onDestroy()
        println("org.b3.foundation.ui.UiApplication.onDestroy()")
    }

    internal fun attach(view: View) {
        check(rootView == null) { "UI is already configured" }

        rootView = view
    }

    private var rootView: View? = null
}
