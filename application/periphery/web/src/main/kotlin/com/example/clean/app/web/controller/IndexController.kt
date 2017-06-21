package com.example.clean.app.web.controller

import com.example.clean.app.web.controller.CommonLinks.customersLink
import org.springframework.hateoas.ResourceSupport
import org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping(path = arrayOf("/", "/api"), produces = arrayOf(APPLICATION_JSON_V1_VALUE))
class IndexController {

    @GetMapping
    fun index(): ResponseEntity<ResourceSupport> {

        val indexLink = linkTo(IndexController::class.java!!)

        val resourceSupport = ResourceSupport()
        resourceSupport.add(indexLink.withSelfRel())
        resourceSupport.add(customersLink())

        return ResponseEntity.ok(resourceSupport)
    }
}