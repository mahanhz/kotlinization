package com.example.clean.app.data.jpa.entity

import javax.persistence.Embeddable

@Embeddable
data class Name(val firstName: String = "",
                val middleName: String = "",
                val lastName: String = "",
                val suffix: String = "") {
}