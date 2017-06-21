package com.example.clean.app.data

import com.example.clean.app.core.domain.Customer
import com.example.clean.app.data.jpa.entity.CustomerEntity
import com.example.clean.app.data.jpa.entity.Name

object JpaRepositoryHelper {

    fun customerEntity(): CustomerEntity {
        return CustomerEntity(123L, name(), age())
    }

    fun name(): Name {
        return Name("John", "", "Doe", "")
    }

    fun age(): Int {
        return 25
    }

    fun customerEntity(customer: Customer): CustomerEntity {
        val id = customer.id.value
        val name = name(customer.name)
        val age = customer.age.value

        return CustomerEntity(id, name, age)
    }

    fun name(customerName: com.example.clean.app.core.domain.Name): Name {
        val firstName = customerName.firstName.value
        val middleName = customerName.middleName.value
        val lastName = customerName.lastName.value
        val suffix = customerName.suffix.value

        return Name(firstName, middleName, lastName, suffix)
    }
}
