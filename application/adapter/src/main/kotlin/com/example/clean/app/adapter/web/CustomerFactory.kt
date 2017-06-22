package com.example.clean.app.adapter.web.api

import com.example.clean.app.core.domain.*


object CustomerFactory {

    fun customer(customer: CustomerDTO): Customer {
        return Customer(Id(customer.id), name(customer.name), Age(customer.age))
    }

    private fun name(name: NameDTO): Name {
        return Name(FirstName(name.firstName),
                    MiddleName(name.middleName),
                    LastName(name.lastName),
                    Suffix(name.suffix))
    }
}