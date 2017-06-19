package com.example.clean.app.core.usecase

import com.example.clean.app.core.boundary.exit.CustomerEditRepository
import com.example.clean.app.core.helper.DomainHelper.customer
import io.kotlintest.mock.mock
import io.kotlintest.specs.FunSpec
import org.mockito.Mockito.times
import org.mockito.Mockito.verify

class CustomerEditUseCaseTest : FunSpec() {
    init {
        val customerEditRepository: CustomerEditRepository = mock()
        val customerEditUseCase: CustomerEditUseCase = CustomerEditUseCase(customerEditRepository)

        test("Should create customer") {
            val customer = customer()
            customerEditUseCase.create(customer)

            verify<CustomerEditRepository>(customerEditRepository, times(1)).create(customer)
        }

        test("Should update customer") {
            val customer = customer()
            customerEditUseCase.update(customer)

            verify<CustomerEditRepository>(customerEditRepository, times(1)).update(customer)
        }

        test("Should delete customer") {
            val customer = customer()
            customerEditUseCase.delete(customer.id)

            verify<CustomerEditRepository>(customerEditRepository, times(1)).delete(customer.id)
        }
    }
}