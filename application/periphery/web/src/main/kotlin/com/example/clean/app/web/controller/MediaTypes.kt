package com.example.clean.app.web.controller

import org.springframework.http.MediaType

const val APPLICATION_JSON_V1_VALUE = "application/vnd.example.clean.v1+json"
const val APPLICATION_VND_ERROR_JSON_VALUE = "application/vnd.error+json"

object MediaTypes {
    val APPLICATION_JSON_V1 = MediaType.valueOf(APPLICATION_JSON_V1_VALUE)
    val APPLICATION_VND_ERROR_JSON = MediaType.valueOf(APPLICATION_VND_ERROR_JSON_VALUE)
}