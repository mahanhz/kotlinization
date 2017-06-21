package com.example.clean.app.adapter.web.api

import com.fasterxml.jackson.annotation.JsonProperty


data class CustomersDTO(@JsonProperty("customers") val customers: List<CustomerDTO>) {
}