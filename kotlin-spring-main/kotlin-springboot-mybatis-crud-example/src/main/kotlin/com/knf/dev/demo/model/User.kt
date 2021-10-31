package com.knf.dev.demo.model

class User {
    var id: Long = 0
    var firstName: String? = null
    var lastName: String? = null
    var emailId: String? = null

    constructor() {}
    constructor(id: Long, firstName: String?, lastName: String?, emailId: String?) : super() {
        this.id = id
        this.firstName = firstName
        this.lastName = lastName
        this.emailId = emailId
    }
}