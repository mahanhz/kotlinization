package com.example.clean.app.core.domain

import org.apache.commons.lang3.StringUtils.trim
import org.apache.commons.lang3.Validate
import org.apache.commons.lang3.Validate.notBlank

class FirstName(value: String) {
    val value: String

    init {
        this.value = validate(value)
    }

    private fun validate(input: String): String {
        val trimmed = trim(notBlank(input))
        Validate.isTrue(trimmed.length <= MAX_LENGTH)

        return trimmed
    }

    companion object {

        val MAX_LENGTH = 25
    }
}