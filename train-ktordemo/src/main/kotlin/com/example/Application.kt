package com.example

import io.ktor.server.application.*
import com.example.plugins.*
import io.ktor.http.*
import io.ktor.server.plugins.statuspages.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun main(args: Array<String>): Unit =
    io.ktor.server.cio.EngineMain.main(args)


fun Application.module() {

    configureDependencyInjection()
    configureExceptionHandling()
    configureSerialization()
//    configureSecurity()
    configureRouting()
}
