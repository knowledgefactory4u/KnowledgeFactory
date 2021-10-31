package com.knf.dev.entity

import javax.persistence.*

@Entity
@Table(name = "user")
data class User(

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Long = 0,
    val firstName: String,
    val lastName: String,
    val email: String
)
