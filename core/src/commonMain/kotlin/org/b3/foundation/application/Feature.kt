package org.b3.foundation.application

interface Feature<in A : Application, C : Any> {
    fun configuration(): C

    fun adapt(
        application: A,
        configuration: C,
    )
}
