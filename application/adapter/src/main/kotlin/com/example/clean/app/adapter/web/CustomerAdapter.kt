package com.example.clean.app.adapter.web

import com.example.clean.app.adapter.web.api.CustomerDTO
import com.example.clean.app.adapter.web.api.CustomerFactory
import com.example.clean.app.adapter.web.api.CustomersDTO
import com.example.clean.app.core.boundary.enter.CustomerEditService
import com.example.clean.app.core.boundary.enter.CustomerService
import com.example.clean.app.core.domain.Id
import org.apache.commons.lang3.Validate


class CustomerAdapter(private val customerService: CustomerService,
                      private val customerEditService: CustomerEditService) {

    fun customers(): CustomersDTO {
        val customers = customerService.customers()

        return CustomersDTO(CustomerDTOFactory.customers(customers))
    }

    fun customer(customerId: Long): CustomerDTO {
        val customer = customerService.customer(Id(customerId))

        return CustomerDTOFactory.customer(customer)
    }

    fun create(customerDTO: CustomerDTO) {
        Validate.notNull(customerDTO)

        customerEditService.create(CustomerFactory.customer(customerDTO))
    }

    fun update(customerDTO: CustomerDTO) {
        Validate.notNull(customerDTO)

        customerEditService.update(CustomerFactory.customer(customerDTO))
    }

    fun delete(customerId: Long) {
        customerEditService.delete(Id(customerId))
    }
}