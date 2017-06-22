package com.example.clean.app.web.controller

import com.example.clean.app.adapter.web.CustomerAdapter
import com.example.clean.app.adapter.web.api.CustomerDTO
import com.example.clean.app.adapter.web.api.CustomersDTO
import org.apache.commons.lang3.Validate
import org.springframework.hateoas.Link
import org.springframework.hateoas.Resource
import org.springframework.hateoas.mvc.ControllerLinkBuilder
import org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo
import org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.net.URI
import javax.validation.Valid
import kotlin.streams.toList

@RestController
@RequestMapping(path = arrayOf("/api/customers"), produces = arrayOf(APPLICATION_JSON_V1_VALUE))
class CustomerController(private val customerAdapter: CustomerAdapter) {

    @GetMapping
    fun customers(): ResponseEntity<Resource<CustomersDTO>> {

        val selfLink = linkTo(methodOn<CustomerController>(CustomerController::class.java).customers())

        val createLink = linkTo(CustomerController::class.java)

        val customersDto = Resource(customerAdapter.customers())
        customersDto.add(selfLink.withSelfRel())
        customersDto.add(CommonLinks.homeLink())
        customersDto.add(createLink.withRel(REL_CREATE))
        customersDto.add(customerLinks())

        return ResponseEntity.ok(customersDto)
    }

    @GetMapping(path = arrayOf("/{customerId}"))
    fun customer(@PathVariable customerId: Long): ResponseEntity<Resource<CustomerDTO>> {

        val selfLink = linkTo(methodOn<CustomerController>(CustomerController::class.java).customer(customerId))

        val updateLink = linkTo(CustomerController::class.java).slash(customerId)
        val deleteLink = linkTo(CustomerController::class.java).slash(customerId)

        val customerDto = Resource(customerAdapter.customer(customerId))
        customerDto.add(selfLink.withSelfRel())
        customerDto.add(CommonLinks.homeLink())
        customerDto.add(CommonLinks.customersLink())
        customerDto.add(updateLink.withRel(REL_UPDATE))
        customerDto.add(deleteLink.withRel(REL_DELETE))

        return ResponseEntity.ok(customerDto)
    }

    @PostMapping(consumes = arrayOf(APPLICATION_JSON_V1_VALUE))
    fun create(@RequestBody @Valid customerDto: CustomerDTO): ResponseEntity<*> {

        customerAdapter.create(customerDto)

        return ResponseEntity.created(URI.create(CommonLinks.customersLink().href)).build<Any>()
    }

    @PutMapping(path = arrayOf("/{customerId}"), consumes = arrayOf(APPLICATION_JSON_V1_VALUE))
    fun update(@PathVariable customerId: Long,
               @RequestBody @Valid customerDto: CustomerDTO): ResponseEntity<*> {

        Validate.isTrue(customerId == customerDto.id, "Customer Id does not match")

        customerAdapter.update(customerDto)

        return ResponseEntity.ok().location(URI.create(CommonLinks.customersLink().href)).build<Any>()
    }

    @DeleteMapping(path = arrayOf("/{customerId}"))
    fun delete(@PathVariable customerId: Long): ResponseEntity<*> {

        customerAdapter.delete(customerId)

        return ResponseEntity.ok().location(URI.create(CommonLinks.customersLink().href)).build<Any>()
    }

    private fun customerLinks(): List<Link> {
        val customers = customerAdapter.customers()

        return customers.customers.stream()
                .map { cust -> linkTo(ControllerLinkBuilder.methodOn<CustomerController>(CustomerController::class.java).customer(cust.id)).withRel(REL_CUSTOMER_PREFIX + cust.id) }
                .toList()
    }
}