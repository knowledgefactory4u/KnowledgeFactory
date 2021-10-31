package com.knf.dev.demo.kotlinspringsecurityjwt.model

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.DBRef
import org.springframework.data.mongodb.core.mapping.Document
import java.util.HashSet
import javax.validation.constraints.Email
import javax.validation.constraints.NotBlank
import javax.validation.constraints.Size

@Document(collection = "employees")
class Employee {
    @Id
    var id: String? = null
    var employeename: @NotBlank @Size(max = 20) String? = null
    var email: @NotBlank @Size(max = 50) @Email String? = null
    var password: @NotBlank @Size(max = 120) String? = null

    @DBRef
    var roles: Set<Role> = HashSet()

    constructor() {}
    constructor(employeename: String?, email: String?, password: String?) : super() {
        this.employeename = employeename
        this.email = email
        this.password = password
    }
}