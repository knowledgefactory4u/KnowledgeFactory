package com.knf.dev.entity

import javax.persistence.*


@Entity
@Table(name = "employee")
class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Long = 0
    var name: String? = null
    var email: String? = null
    var country: String? = null
    var age = 0
    var role: String? = null

    constructor() : super() {}
    constructor(
        name: String?, email: String?, country: String?,
        age: Int, role: String?
    ) : super() {
        this.name = name
        this.email = email
        this.country = country
        this.age = age
        this.role = role
    }
}

