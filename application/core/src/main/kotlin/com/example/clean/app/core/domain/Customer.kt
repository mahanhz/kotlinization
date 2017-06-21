package com.example.clean.app.core.domain

data class Customer(val id: Id, val name: Name, val age: Age) {

    fun canPurchaseFireworks() : Boolean {
        return age.value > 21
    }
}