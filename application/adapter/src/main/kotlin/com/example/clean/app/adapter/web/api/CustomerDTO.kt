package com.example.clean.app.adapter.web.api

import com.fasterxml.jackson.annotation.JsonProperty


data class CustomerDTO(@JsonProperty("id") val id: Long,
                       @JsonProperty("name") val name: NameDTO,
                       @JsonProperty("age") val age: Int,
                       @JsonProperty("canPurchaseFireworks") val canPurchaseFireworks: Boolean) {

}