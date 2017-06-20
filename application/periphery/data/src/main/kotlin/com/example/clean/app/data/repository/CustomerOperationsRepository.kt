package com.example.clean.app.data.repository

import com.example.clean.app.core.boundary.exit.CustomerEditRepository
import com.example.clean.app.core.domain.Customer
import com.example.clean.app.core.domain.Id
import com.example.clean.app.data.jpa.entity.CustomerEntity
import com.example.clean.app.data.jpa.entity.Name
import com.example.clean.app.data.jpa.repository.CustomerJpaRepository


class CustomerOperationsRepository(val customerJpaRepository: CustomerJpaRepository) : CustomerEditRepository {
    override fun create(customer: Customer) {
        customerJpaRepository.save(customerEntity(customer))
    }

    override fun update(customer: Customer) {
        customerJpaRepository.save(customerEntity(customer))
    }

    override fun delete(customerId: Id) {
        customerJpaRepository.delete(customerId.value)
    }

    private fun customerEntity(customer: Customer): CustomerEntity {
        val id = customer.id.value
        val name = name(customer.name)
        val age = customer.age.value

        return CustomerEntity(id, name, age)
    }

    private fun name(customerName: com.example.clean.app.core.domain.Name): Name {

        return Name(customerName.firstName.value,
                    customerName.middleName.value,
                    customerName.lastName.value,
                    customerName.suffix.value)
    }
}