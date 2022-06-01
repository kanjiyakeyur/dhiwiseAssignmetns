package com.example.plugins

import com.example.controller.TrainController
import io.ktor.server.application.*
import io.ktor.server.routing.*

fun Application.configureRouting() {

    routing {
        trainRoute()
    }
}

fun Route.trainRoute() {

    route("train"){
        val trainController by inject<TrainController>()
        put("/list") {
            trainController.list(this.context)
        }
        put {
            trainController.create(this.context)
        }
        delete {
            trainController.delete(this.context)
        }
    }
}
