package com.knf.dev.demo.kotlinspringjpamustachecrud.model

import javax.persistence.*

@Entity
@Table(name = "user")
class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null

    @Column(name = "first_name")
    var first_name: String? = null

    @Column(name = "last_name")
    var last_name: String? = null

    @Column(name = "email", nullable = false, length = 200)
    var email: String? = null
}