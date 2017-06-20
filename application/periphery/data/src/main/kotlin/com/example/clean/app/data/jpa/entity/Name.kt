package com.example.clean.app.data.jpa.entity

import javax.persistence.Embeddable

@Embeddable
class Name {
    var firstName: String = ""
    var middleName: String = ""
    var lastName: String = ""
    var suffix: String = ""

    constructor() {}

    constructor(firstName: String, middleName: String, lastName: String, suffix: String) {
        this.firstName = firstName
        this.middleName = middleName
        this.lastName = lastName
        this.suffix = suffix
    }
}