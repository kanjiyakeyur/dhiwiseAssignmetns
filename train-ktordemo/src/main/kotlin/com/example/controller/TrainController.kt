package com.example.controller

import com.example.models.Train
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import com.example.comman.ResponseData
import com.example.constants.ResponseStatus
import com.example.models.validate

class TrainController() {
    private val listOfTrain = arrayListOf<Train>()

    suspend fun create(ctx: ApplicationCall) {
        val train = ctx.receiveOrNull<Train>()?:return
//        train.validate()
        listOfTrain.add(train)
        ctx.respond(ResponseData(
            code = ResponseStatus.OK.status,
            message = "Train insert successfully",
            data = train
        ))
    }

//    suspend fun update(ctx: ApplicationCall) {
//        val train = ctx.receiveOrNull<Train>()?:return
//        ctx.respond(ResponseData(
//            code = ResponseStatus.OK.status,
//            message = "Train updated successfully",
//            data = train
//        ))
//    }

    suspend fun delete(ctx: ApplicationCall) {
        val train = ctx.receiveOrNull<Train>()?:return
        ctx.respond(ResponseData(
            code = ResponseStatus.OK.status,
            message = "Train deleted successfully",
            data = train
        ))
    }

    suspend fun list(ctx: ApplicationCall) {

        ctx.respond(ResponseData(
            code = ResponseStatus.OK.status,
            message = "success.",
            data = listOfTrain
        ))
    }
}