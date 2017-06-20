package com.example.clean.app.data.jpa.entity

import javax.persistence.*

@Entity(name = "customer_t")
class CustomerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = 0

    @Embedded
    var name: Name = Name()

    var age: Int = 0

    // Needed by JPA
    protected constructor() {}

    constructor(id: Long, name: Name, age: Int) {
        this.id = id
        this.name = name
        this.age = age
    }
}