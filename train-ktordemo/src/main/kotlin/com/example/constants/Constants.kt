package com.example.constants


enum class ResponseStatus(val status: String) {
    OK("OK"),
    UNAUTHORIZED("UNAUTHORIZED"),
    SERVER_ERROR("SERVER_ERROR"),
    BAD_REQUEST("BAD_REQUEST"),
    NOT_FOUND("NOT_FOUND");
}