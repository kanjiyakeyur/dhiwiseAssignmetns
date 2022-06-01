package com.example.plugins

import com.example.comman.ResponseData
import com.example.constants.ResponseStatus
import com.google.gson.JsonParseException
import com.google.gson.JsonSyntaxException
import io.ktor.http.*
import io.ktor.serialization.*
import io.ktor.server.application.*
import io.ktor.server.plugins.*
import io.ktor.server.plugins.statuspages.*
import io.ktor.server.response.*


fun Application.configureExceptionHandling() {
    install(StatusPages) {
        handleExceptions()
    }
}

private fun StatusPagesConfig.handleExceptions() {
    exception<Throwable> { call, cause ->
        val pairOfStatusResponseCode = when (cause) {

            is BadRequestException, is JsonParseException,
            is IllegalArgumentException, is JsonSyntaxException,
            is InvalidBodyException, is JsonConvertException -> Pair(
                HttpStatusCode.BadRequest,
                ResponseStatus.BAD_REQUEST
            )

            is IllegalAccessException, is AuthorizationException -> Pair(
                HttpStatusCode.Unauthorized,
                ResponseStatus.UNAUTHORIZED
            )

            is CloneNotSupportedException -> Pair(HttpStatusCode.Conflict, ResponseStatus.SERVER_ERROR)

            is NotFoundException -> Pair(HttpStatusCode.NotFound, ResponseStatus.NOT_FOUND)

            else -> Pair(HttpStatusCode.InternalServerError, ResponseStatus.SERVER_ERROR)

        }
        val errorResponse = ResponseData(
            code = pairOfStatusResponseCode.second.status,
            message = cause.message ?: ""
        )
        call.respond(pairOfStatusResponseCode.first, errorResponse)
        cause.printStackTrace()
    }
}

class AuthenticationException(msg: String) : Exception(msg)
class AuthorizationException(msg: String) : Exception(msg)
class DuplicateEmailException(msg: String) : Exception(msg)
