package com.example.clean.app.core.boundary.exit

import com.example.clean.app.core.domain.Customer
import com.example.clean.app.core.domain.Id


interface CustomerRepository {

    fun customers(): List<Customer>

    fun customer(customerId: Id): Customer
}