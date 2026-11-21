package org.b3.foundation.server

import org.b3.foundation.runtime.LifecycleOwner

object ApplicationMain {
    fun main(args: Array<String>) {
        val owner = LifecycleOwner(ServerApplication)

        try {
            owner.create()
        } finally {
            owner.destroy()
        }
    }
}
