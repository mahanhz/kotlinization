package com.example.clean.app.data.jpa.entity

import javax.persistence.*

@Entity(name = "customer_t")
class CustomerEntity : BaseEntity {

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

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other?.javaClass != javaClass) return false

        other as CustomerEntity

        if (name != other.name) return false
        if (age != other.age) return false

        return true
    }

    override fun hashCode(): Int {
        var result = name.hashCode()
        result = 31 * result + age
        return result
    }

    override fun toString(): String {
        return "CustomerEntity(id=$id, name=$name, age=$age)"
    }
}