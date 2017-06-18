package com.example.clean.app.core.boundary.enter

import com.example.clean.app.core.domain.Customer
import com.example.clean.app.core.domain.Id


interface CustomerService {

    fun customers(): List<Customer>

    fun customer(customerId: Id): Customer
}