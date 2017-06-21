package com.example.clean.app.adapter.web.api

import com.fasterxml.jackson.annotation.JsonProperty


data class AgeDTO(@JsonProperty("age") val age: Int) {

}