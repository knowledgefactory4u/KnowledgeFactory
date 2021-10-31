package com.knf.dev.entity

import javax.persistence.*

@Entity
@Table(name = "user")
data class User(

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Long,
    val firstName: String,
    val lastName: String,
    val emailId: String
)
