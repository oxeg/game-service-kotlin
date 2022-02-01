package dev.oxeg.gameservice

import io.micronaut.runtime.Micronaut.*

fun main(args: Array<String>) {
    build()
        .args(*args)
        .packages("dev.oxeg")
        .start()
}

