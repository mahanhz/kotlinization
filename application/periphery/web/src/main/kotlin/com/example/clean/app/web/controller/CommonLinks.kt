package com.example.clean.app.web.controller

import org.springframework.hateoas.Link
import org.springframework.hateoas.mvc.ControllerLinkBuilder
import org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo

const val REL_HOME = "home"
const val REL_CUSTOMERS = "customers"
const val REL_CREATE = "create"
const val REL_UPDATE = "update"
const val REL_DELETE = "delete"
const val REL_CUSTOMER_PREFIX = "customer-"

object CommonLinks {

    fun homeLink(): Link {
        val homeLink = linkTo(IndexController::class.java)
        return homeLink.withRel(REL_HOME)
    }

    fun customersLink(): Link {
        val customersLink = linkTo(ControllerLinkBuilder.methodOn<CustomerController>(CustomerController::class.java).customers())
        return customersLink.withRel(REL_CUSTOMERS)
    }
}