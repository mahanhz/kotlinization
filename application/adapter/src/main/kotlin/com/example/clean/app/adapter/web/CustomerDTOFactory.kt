package com.example.clean.app.adapter.web

import com.example.clean.app.adapter.web.api.CustomerDTO
import com.example.clean.app.adapter.web.api.NameDTO
import com.example.clean.app.core.domain.Customer
import com.example.clean.app.core.domain.Name
import kotlin.streams.toList


object CustomerDTOFactory {

    fun customers(customers: List<Customer>): List<CustomerDTO> {
        return customers.stream()
                .map { customer(it) }
                .toList()
    }

    fun customer(customer: Customer): CustomerDTO {
        return CustomerDTO(customer.id.value,
                           name(customer.name),
                           customer.age.value,
                           customer.canPurchaseFireworks())
    }

    private fun name(name: Name): NameDTO {
        return NameDTO(name.firstName.value,
                       name.middleName.value,
                       name.lastName.value,
                       name.suffix.value)
    }
}