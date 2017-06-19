package com.example.clean.app.core.domain

import org.apache.commons.lang3.StringUtils
import org.apache.commons.lang3.Validate

const val SUFFIX_MAX_LENGTH = 10

class Suffix(value: String) {
    val value: String

    init {
        this.value = validate(value)
    }

    private fun validate(input: String): String {
        val trimmed = StringUtils.trim(input)
        Validate.isTrue(trimmed.length <= SUFFIX_MAX_LENGTH)

        return trimmed
    }
}