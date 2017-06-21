package com.example.clean.app.data.repository

import com.example.clean.app.core.helper.DomainHelper.customer
import com.example.clean.app.data.JpaRepositoryHelper.customerEntity
import com.example.clean.app.data.jpa.repository.CustomerJpaRepository
import io.kotlintest.mock.mock
import io.kotlintest.specs.FunSpec
import org.mockito.Mockito.times
import org.mockito.Mockito.verify

class CustomerOperationsRepositoryTest : FunSpec() {
    init {
        val customerJpaRepository: CustomerJpaRepository = mock()
        val customerOperationsRepository: CustomerOperationsRepository = CustomerOperationsRepository(customerJpaRepository)

        val customer = customer()
        test("Should create customer") {
            customerOperationsRepository.create(customer)

            verify<CustomerJpaRepository>(customerJpaRepository, times(1)).save(customerEntity(customer))
        }

        test("Should update customer") {
            customerOperationsRepository.update(customer)

            verify(customerJpaRepository, times(1)).save(customerEntity(customer))
        }

        test("Should delete customer") {
            customerOperationsRepository.delete(customer.id)

            verify(customerJpaRepository, times(1)).delete(customer.id.value)
        }
    }
}