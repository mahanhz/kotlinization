package com.example.clean.app.adapter.web

import com.example.clean.app.adapter.helper.DomainHelper.customer
import com.example.clean.app.adapter.web.api.CustomerFactory
import com.example.clean.app.adapter.web.api.CustomersDTO
import com.example.clean.app.core.boundary.enter.CustomerEditService
import com.example.clean.app.core.boundary.enter.CustomerService
import com.example.clean.app.core.domain.Id
import io.kotlintest.matchers.haveSize
import io.kotlintest.matchers.shouldBe
import io.kotlintest.matchers.shouldHave
import io.kotlintest.matchers.shouldNotBe
import io.kotlintest.mock.`when`
import io.kotlintest.mock.mock
import io.kotlintest.specs.FunSpec
import org.mockito.Mockito.times
import org.mockito.Mockito.verify

class CustomerAdapterTest : FunSpec() {
    init {
        val customerService: CustomerService = mock()
        val customerEditService: CustomerEditService = mock()
        val customerAdapter: CustomerAdapter = CustomerAdapter(customerService, customerEditService)

        test("Should get customers") {
            `when`(customerService.customers()).thenReturn(listOf(customer()))

            val customersDTO = customerAdapter.customers()

            customersDTO shouldNotBe emptyList<CustomersDTO>()
            customersDTO.customers shouldHave haveSize(1)

            val (id, name, age) = customersDTO.customers[0]
            id shouldBe customer().id.value
            name.firstName shouldBe customer().name.firstName.value
            name.lastName shouldBe customer().name.lastName.value
            age shouldBe customer().age.value
        }

        test("Should get customer") {
            `when`(customerService.customer(id())).thenReturn(customer())

            val customer = customerAdapter.customer(id().value)

            customer.name.firstName shouldBe customer().name.firstName.value
            customer.name.lastName shouldBe customer().name.lastName.value
            customer.age shouldBe customer().age.value
        }

        test("Should create customer") {
            val customerDTO = CustomerDTOFactory.customer(customer())

            customerAdapter.create(customerDTO)

            verify<CustomerEditService>(customerEditService, times(1)).create(CustomerFactory.customer(customerDTO))
        }

        test("Should update customer") {
            val customerDTO = CustomerDTOFactory.customer(customer())

            customerAdapter.update(customerDTO)

            verify<CustomerEditService>(customerEditService, times(1)).update(CustomerFactory.customer(customerDTO))
        }

        test("Should delete customer") {
            customerAdapter.delete(customer().id.value)

            verify<CustomerEditService>(customerEditService, times(1)).delete(customer().id)
        }
    }

    private fun id() = Id(123L)
}