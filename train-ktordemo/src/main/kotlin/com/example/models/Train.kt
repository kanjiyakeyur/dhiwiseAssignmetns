package com.example.models

import io.ktor.server.plugins.*

data class Train(
    val id: Int?,
    val name: String?,
    val source: String?,
    val destination: String?,
    val departureTime : String?
)

fun Train?.validate() {
    require(this != null) {
        throw BadRequestException("Empty request")
    }
    require(this.name != null) {
        throw BadRequestException("Invalid name")
    }
    require(this.source != null) {
        throw BadRequestException("Invalid source")
    }
    require(this.destination != null) {
        throw BadRequestException("Invalid destination")
    }
    require(this.departureTime != null) {
        throw BadRequestException("Invalid departureTime")
    }
}