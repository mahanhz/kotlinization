package com.example.clean.app.core.helper

import com.example.clean.app.core.domain.*


object DomainHelper {

    fun customer(): Customer {
        return Customer(Id(123L), name(), age(25))
    }

    fun name(): Name {
        return Name(firstName(), middleName(), lastName(), suffix())
    }

    fun age(age:  Int): Age {
        return Age(age)
    }

    fun firstName(): FirstName {
        return FirstName("firstName")
    }

    fun middleName(): MiddleName {
        return MiddleName("middleName")
    }

    fun lastName(): LastName {
        return LastName("lastName")
    }

    fun suffix(): Suffix {
        return Suffix("suffix")
    }
}
