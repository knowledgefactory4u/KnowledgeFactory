package com.knf.dev.demo.kotlinspringjpafreemarkercrud.model

import javax.persistence.*

@Entity
@Table(name = "user")
class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null

    @Column(name = "first_name")
    var firstName: String? = null

    @Column(name = "last_name")
    var lastName: String? = null

    @Column(name = "email", nullable = false, length = 200)
    var email: String? = null

    constructor() : super() {}
    constructor(firstName: String?, lastName: String?, email: String?) : super() {
        this.firstName = firstName
        this.lastName = lastName
        this.email = email
    }

    override fun toString(): String {
        return ("User [id=" + id + ", firstName=" + firstName + ", lastName="
                + lastName + ", email=" + email + "]")
    }
}