package com.example.plugins

import com.example.controller.TrainController
import com.example.models.Train
import io.ktor.server.application.*
import org.koin.dsl.module
import org.koin.logger.SLF4JLogger

fun Application.configureDependencyInjection() {

    val module = module {
        single { TrainController() }
    }
    install(Koin) {
        SLF4JLogger()
        modules = arrayListOf(module)
    }
}