package com.example.clean.app.core.domain

import org.apache.commons.lang3.Validate.inclusiveBetween

const val MAX_AGE = 125
const val MIN_AGE = 18

class Age(value: Int) {
    val value: Int

    init {
        inclusiveBetween(MIN_AGE, MAX_AGE, value, "Invalid age")

        this.value = value
    }
}