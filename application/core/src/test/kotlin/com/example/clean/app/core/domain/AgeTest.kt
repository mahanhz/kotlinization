package com.example.clean.app.core.domain

import com.example.clean.app.core.helper.ExceptionHelper.invalidMatching
import com.example.clean.app.core.helper.ExceptionHelper.valid
import com.example.clean.app.core.helper.NoException
import io.kotlintest.matchers.shouldBe
import io.kotlintest.properties.forAll
import io.kotlintest.properties.headers
import io.kotlintest.properties.row
import io.kotlintest.properties.table
import io.kotlintest.specs.StringSpec

class AgeTest : StringSpec() {
    init {
        "Should check value " {
            val valuesTable = table(
                    headers("value", "result"),
                    row(MIN_AGE, valid()),
                    row(MAX_AGE, valid()),
                    row(MIN_AGE - 1, invalidMatching(IllegalArgumentException::class.java)),
                    row(MAX_AGE + 1, invalidMatching(IllegalArgumentException::class.java))
            )
            forAll(valuesTable) { value, result ->
                var actualException: Class<out Exception> = NoException::class.java

                try {
                    Age(value)
                } catch (ex: Exception) {
                    actualException = ex.javaClass
                }
                actualException shouldBe result
            }
        }
    }
}