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
import org.apache.commons.lang3.StringUtils.repeat

class LastNameTest : StringSpec() {
    init {
        "Should check value " {
            val valuesTable = table(
                    headers("value", "result"),
                    row("John", valid()),
                    row(repeat("x", LASTNAME_MAX_LENGTH), valid()),
                    row("", invalidMatching(IllegalArgumentException::class.java)),
                    row(" ", invalidMatching(IllegalArgumentException::class.java)),
                    row(repeat("x", LASTNAME_MAX_LENGTH + 1), invalidMatching(IllegalArgumentException::class.java))
            )
            forAll(valuesTable) { value, result ->
                var actualException: Class<out Exception> = NoException::class.java

                try {
                    LastName(value)
                } catch (ex: Exception) {
                    actualException = ex.javaClass
                }
                actualException shouldBe result
            }
        }
    }
}