package com.example.clean.app.core.domain

import org.apache.commons.lang3.Validate.inclusiveBetween

class Age(value: Int) {
    val value: Int

    init {
        inclusiveBetween(MIN_AGE, MAX_AGE, value, "Invalid age")

        this.value = value
    }

    companion object {

        val MAX_AGE = 125
        val MIN_AGE = 18

    }
}