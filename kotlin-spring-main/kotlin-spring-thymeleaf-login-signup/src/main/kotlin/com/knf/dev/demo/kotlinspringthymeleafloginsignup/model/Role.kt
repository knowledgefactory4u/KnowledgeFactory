package com.knf.dev.demo.kotlinspringthymeleafloginsignup.model

import javax.persistence.*

@Entity
@Table(name = "role")
class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null
    var name: String? = null

    constructor() {}
    constructor(name: String?) : super() {
        this.name = name
    }
}