package com.example.clean.app.data.jpa.entity

import javax.persistence.MappedSuperclass
import javax.persistence.Version

@MappedSuperclass
class BaseEntity {

    @Version
    var version: Int = 0
}
