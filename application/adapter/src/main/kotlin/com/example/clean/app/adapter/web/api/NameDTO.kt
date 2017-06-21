package com.example.clean.app.adapter.web.api

import com.fasterxml.jackson.annotation.JsonProperty


data class NameDTO(@JsonProperty("firstName") val firstName: String,
                   @JsonProperty("middleName") val middleName: String,
                   @JsonProperty("lastName") val lastName: String,
                   @JsonProperty("suffix") val suffix: String) {

}