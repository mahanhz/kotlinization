package com.example.clean.app.core.domain

import org.apache.commons.lang3.StringUtils
import org.apache.commons.lang3.Validate

const val MIDDLENAME_MAX_LENGTH = 25

class MiddleName(value: String) {
    val value: String

    init {
        this.value = validate(value)
    }

    private fun validate(input: String): String {
        val trimmed = StringUtils.trim(input)
        Validate.isTrue(trimmed.length <= MIDDLENAME_MAX_LENGTH)

        return trimmed
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other?.javaClass != javaClass) return false

        other as MiddleName

        if (value != other.value) return false

        return true
    }

    override fun hashCode(): Int {
        return value.hashCode()
    }

    override fun toString(): String {
        return "MiddleName(value='$value')"
    }
}