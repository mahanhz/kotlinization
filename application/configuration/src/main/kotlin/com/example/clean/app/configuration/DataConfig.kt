package com.example.clean.app.configuration

import com.example.clean.app.core.boundary.exit.CustomerEditRepository
import com.example.clean.app.core.boundary.exit.CustomerRepository
import com.example.clean.app.data.jpa.repository.CustomerJpaRepository
import com.example.clean.app.data.jpa.repository.JpaPackageMarker
import com.example.clean.app.data.repository.CustomerDetailsRepository
import com.example.clean.app.data.repository.CustomerOperationsRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.jpa.repository.config.EnableJpaRepositories
import org.springframework.transaction.annotation.EnableTransactionManagement

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackageClasses = arrayOf(JpaPackageMarker::class))
class DataConfig {

    @Autowired
    lateinit var customerJpaRepository: CustomerJpaRepository

    @Bean
    fun customerRepository(): CustomerRepository {
        return CustomerDetailsRepository(customerJpaRepository)
    }

    @Bean
    fun customerEditRepository(): CustomerEditRepository {
        return CustomerOperationsRepository(customerJpaRepository)
    }
}