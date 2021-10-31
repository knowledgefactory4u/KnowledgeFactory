package com.knf.dev.KotlinSpringExportPDF.model

import javax.persistence.*

@Entity
@Table(name = "employees")
class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Long = 0

    @Column(name = "firstname")
    var firstName: String? = null

    @Column(name = "lastname")
    var lastName: String? = null

    protected constructor() {}
    constructor(firstName: String?, lastName: String?) {
        this.firstName = firstName
        this.lastName = lastName
    }
}