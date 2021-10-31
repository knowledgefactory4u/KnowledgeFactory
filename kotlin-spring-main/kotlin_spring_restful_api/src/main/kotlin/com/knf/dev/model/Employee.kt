package com.knf.dev.model

import org.bson.types.ObjectId
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.web.bind.annotation.CrossOrigin

@Document(collection = "employees")
data class Employee(
        @Id
        var id: String? = ObjectId().toHexString(),
        val firstName: String,
        val lastName: String,
        val emailId: String
)