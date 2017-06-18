package com.example.clean.app.core.domain

import com.example.clean.app.core.helper.DomainHelper.firstName
import com.example.clean.app.core.helper.DomainHelper.lastName
import com.example.clean.app.core.helper.DomainHelper.middleName
import com.example.clean.app.core.helper.DomainHelper.suffix
import com.example.clean.app.core.helper.ExceptionHelper.valid
import com.example.clean.app.core.helper.NoException
import io.kotlintest.matchers.shouldBe
import io.kotlintest.properties.forAll
import io.kotlintest.properties.headers
import io.kotlintest.properties.row
import io.kotlintest.properties.table
import io.kotlintest.specs.StringSpec

class NameTest : StringSpec() {
    init {
        "Should check values " {
            val valuesTable = table(
                    headers("first name", "middle name", "last name", "suffix", "result"),
                    row(firstName(), middleName(), lastName(), suffix(), valid())
            )
            forAll(valuesTable) { firstname, middleName, lastName, suffix, result ->
                var actualException: Class<out Exception> = NoException::class.java

                try {
                    Name(firstName(), middleName, lastName, suffix)
                } catch (ex: Exception) {
                    actualException = ex.javaClass
                }
                actualException shouldBe result
            }
        }
    }
}