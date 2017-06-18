package com.example.clean.app.core.domain

import com.example.clean.app.core.helper.DomainHelper.age
import com.example.clean.app.core.helper.DomainHelper.name
import com.example.clean.app.core.helper.ExceptionHelper.valid
import com.example.clean.app.core.helper.NoException
import io.kotlintest.matchers.shouldBe
import io.kotlintest.properties.forAll
import io.kotlintest.properties.headers
import io.kotlintest.properties.row
import io.kotlintest.properties.table
import io.kotlintest.specs.StringSpec

class CustomerTest : StringSpec() {
    init {
        "Should check values " {
            val valuesTable = table(
                    headers("id", "name", "age", "result"),
                    row(123L, name(), age(18), valid())
            )
            forAll(valuesTable) { id, name, age, result ->
                var actualException: Class<out Exception> = NoException::class.java

                try {
                    Customer(Id(id), name, age)
                } catch (ex: Exception) {
                    actualException = ex.javaClass
                }
                actualException shouldBe result
            }
        }
    }
}