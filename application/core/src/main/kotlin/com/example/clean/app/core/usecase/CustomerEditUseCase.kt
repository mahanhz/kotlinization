package com.example.clean.app.core.usecase

import com.example.clean.app.core.boundary.enter.CustomerEditService
import com.example.clean.app.core.boundary.exit.CustomerEditRepository
import com.example.clean.app.core.domain.Customer
import com.example.clean.app.core.domain.Id


class CustomerEditUseCase(private val customerEditRepository: CustomerEditRepository) : CustomerEditService {

    override fun create(customer: Customer) {
        customerEditRepository.create(customer)
    }

    override fun update(customer: Customer) {
        customerEditRepository.update(customer)
    }

    override fun delete(customerId: Id) {
        customerEditRepository.delete(customerId)
    }
}