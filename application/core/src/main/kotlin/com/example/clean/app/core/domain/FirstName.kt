package com.example.clean.app.core.domain

import org.apache.commons.lang3.StringUtils
import org.apache.commons.lang3.Validate

class FirstName(value: String) {
    val value: String

    init {
        this.value = validate(value)
    }

    private fun validate(input: String): String {
        val trimmed = StringUtils.trim(input)
        Validate.isTrue(trimmed.length <= MAX_LENGTH)

        return trimmed
    }

    companion object {

        val MAX_LENGTH = 25
    }
}