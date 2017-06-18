package com.example.clean.app.core.usecase

import com.example.clean.app.core.boundary.enter.CustomerService
import com.example.clean.app.core.boundary.exit.CustomerRepository
import com.example.clean.app.core.domain.Customer
import com.example.clean.app.core.domain.Id


class CustomerDetailsUseCase(val customerRepository: CustomerRepository) : CustomerService {

    override fun customers(): List<Customer> {
        return customerRepository.customers()
    }

    override fun customer(customerId: Id): Customer {
        return customerRepository.customer(customerId)
    }
}