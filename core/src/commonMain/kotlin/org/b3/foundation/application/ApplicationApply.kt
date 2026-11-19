package org.b3.foundation.application

fun <A : Application, C : Any> A.apply(
    feature: Feature<A, C>,
    configure: C.() -> Unit = {},
): A = this.also { application ->
    val configuration = feature.configuration()
        .apply(configure)

    feature.adapt(application, configuration)
}
