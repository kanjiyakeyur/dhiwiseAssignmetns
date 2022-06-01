package com.example.comman

data class ResponseData(
    val code: String,
    val message: String,
    val data: Any? = null
)