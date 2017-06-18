package com.example.clean.app.core.boundary.exit

import com.example.clean.app.core.domain.Customer
import com.example.clean.app.core.domain.Id


interface CustomerEditRepository {

    fun create(customer: Customer)

    fun update(customer: Customer)

    fun delete(customerId: Id)
}