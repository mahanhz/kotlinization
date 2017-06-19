package com.example.clean.app.core.usecase

import com.example.clean.app.core.boundary.exit.CustomerRepository
import com.example.clean.app.core.domain.Customer
import com.example.clean.app.core.domain.Id
import com.example.clean.app.core.helper.DomainHelper.customer
import io.kotlintest.matchers.haveSize
import io.kotlintest.matchers.shouldBe
import io.kotlintest.matchers.shouldHave
import io.kotlintest.matchers.shouldNotBe
import io.kotlintest.mock.`when`
import io.kotlintest.mock.mock
import io.kotlintest.specs.FunSpec

class CustomerDetailsUseCaseTest : FunSpec() {
    init {
        val customerRepository: CustomerRepository = mock()
        val customerDetailsUseCase: CustomerDetailsUseCase = CustomerDetailsUseCase(customerRepository)

        test("Should get customers") {
            `when`(customerRepository.customers()).thenReturn(listOf(customer()))

            val customers = customerDetailsUseCase.customers()

            customers shouldNotBe emptyList<Customer>()
            customers shouldHave haveSize<Customer>(1)

            val (id, name, age) = customers[0]
            id.value shouldBe customer().id.value
            name.firstName.value shouldBe customer().name.firstName.value
            name.lastName.value shouldBe customer().name.lastName.value
            age.value shouldBe customer().age.value
        }

        test("Should get customer") {
            `when`(customerRepository.customer(id())).thenReturn(customer())

            val customer = customerDetailsUseCase.customer(id())

            customer.id.value shouldBe customer().id.value
            customer.name.firstName.value shouldBe customer().name.firstName.value
            customer.name.lastName.value shouldBe customer().name.lastName.value
            customer.age.value shouldBe customer().age.value
        }
    }

    private fun id() = Id(123L)
}