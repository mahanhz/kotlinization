package com.example.clean.app.core.boundary.enter

import com.example.clean.app.core.domain.Customer
import com.example.clean.app.core.domain.Id


interface CustomerEditService {

    fun create(customer: Customer)

    fun update(customer: Customer)

    fun delete(customerId: Id)
}