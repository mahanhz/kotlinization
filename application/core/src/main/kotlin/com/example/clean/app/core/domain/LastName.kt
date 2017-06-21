package com.example.clean.app.core.domain

import org.apache.commons.lang3.StringUtils.trim
import org.apache.commons.lang3.Validate.isTrue
import org.apache.commons.lang3.Validate.notBlank

const val LASTNAME_MAX_LENGTH = 25

class LastName(value: String) {
    val value: String

    init {
        this.value = validate(value)
    }

    private fun validate(input: String): String {
        val trimmed = trim(notBlank(input))
        isTrue(trimmed.length <= LASTNAME_MAX_LENGTH)

        return trimmed
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other?.javaClass != javaClass) return false

        other as LastName

        if (value != other.value) return false

        return true
    }

    override fun hashCode(): Int {
        return value.hashCode()
    }

    override fun toString(): String {
        return "LastName(value='$value')"
    }
}