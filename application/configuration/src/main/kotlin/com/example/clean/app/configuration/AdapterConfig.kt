package com.example.clean.app.configuration

import com.example.clean.app.adapter.web.CustomerAdapter
import com.example.clean.app.core.boundary.enter.CustomerEditService
import com.example.clean.app.core.boundary.enter.CustomerService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class AdapterConfig {

    @Autowired
    lateinit var customerService: CustomerService

    @Autowired
    lateinit var customerEditService: CustomerEditService

    @Bean
    fun customerAdapter(): CustomerAdapter {
        return CustomerAdapter(customerService, customerEditService)
    }
}