package com.example.clean.app.data.repository

import com.example.clean.app.core.boundary.exit.CustomerRepository
import com.example.clean.app.core.domain.*
import com.example.clean.app.data.jpa.entity.CustomerEntity
import com.example.clean.app.data.jpa.entity.Name
import com.example.clean.app.data.jpa.repository.CustomerJpaRepository
import kotlin.streams.toList


class CustomerDetailsRepository(val customerJpaRepository: CustomerJpaRepository) : CustomerRepository {

    override fun customers(): List<Customer> {
        val customers = customerJpaRepository.findAll()

        return customers.stream()
                .map { customer(it) }
                .toList()
    }

    override fun customer(customerId: Id): Customer {
        val customer = customerJpaRepository.findOne(customerId.value)

        return customer(customer)
    }

    private fun customer(customer: CustomerEntity): Customer {
        return Customer(id(customer), name(customer.name), Age(customer.age))
    }

    private fun id(customer: CustomerEntity): Id {
        return Id(customer.id)
    }

    private fun name(name: Name): com.example.clean.app.core.domain.Name {
        return com.example.clean.app.core.domain.Name(FirstName(name.firstName),
                                                      MiddleName(name.middleName),
                                                      LastName(name.lastName),
                                                      Suffix(name.suffix))
    }
}