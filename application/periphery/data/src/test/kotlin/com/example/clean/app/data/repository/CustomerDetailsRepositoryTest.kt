package com.example.clean.app.data.repository

import com.example.clean.app.core.domain.Customer
import com.example.clean.app.core.domain.Id
import com.example.clean.app.core.helper.DomainHelper
import com.example.clean.app.data.JpaRepositoryHelper.customerEntity
import com.example.clean.app.data.jpa.repository.CustomerJpaRepository
import io.kotlintest.matchers.haveSize
import io.kotlintest.matchers.shouldBe
import io.kotlintest.matchers.shouldHave
import io.kotlintest.matchers.shouldNotBe
import io.kotlintest.mock.`when`
import io.kotlintest.mock.mock
import io.kotlintest.specs.FunSpec

class CustomerDetailsRepositoryTest : FunSpec() {
    init {
        val customerJpaRepository: CustomerJpaRepository = mock()
        val customerDetailsRepository: CustomerDetailsRepository = CustomerDetailsRepository(customerJpaRepository)

        test("Should get customers") {
            `when`(customerJpaRepository.findAll()).thenReturn(listOf(customerEntity()))

            val customers = customerDetailsRepository.customers()

            customers shouldNotBe emptyList<Customer>()
            customers shouldHave haveSize<Customer>(1)

            val (id, name, age) = customers[0]
            id.value shouldBe DomainHelper.customer().id.value
            name.firstName.value shouldBe customerEntity().name.firstName
            name.lastName.value shouldBe customerEntity().name.lastName
            age.value shouldBe customerEntity().age
        }

        test("Should get customer") {
            `when`(customerJpaRepository.findOne(id().value)).thenReturn(customerEntity())

            val customer = customerDetailsRepository.customer(id())

            customer.id.value shouldBe DomainHelper.customer().id.value
            customer.name.firstName.value shouldBe customerEntity().name.firstName
            customer.name.lastName.value shouldBe customerEntity().name.lastName
            customer.age.value shouldBe customerEntity().age
        }
    }

    private fun id() = Id(123L)
}