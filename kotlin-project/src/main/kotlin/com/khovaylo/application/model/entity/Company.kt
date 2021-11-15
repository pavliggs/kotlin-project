package com.khovaylo.application.model.entity

import java.util.*
import javax.persistence.Column
import javax.persistence.SequenceGenerator

@SequenceGenerator(name = BaseEntity.SEQUENCE_BASE_GENERATOR, sequenceName = "company_seq", allocationSize = 1)
class Company : BaseEntity<Long> {

    companion object {
        const val SEQUENCE_BASE_GENERATOR = BaseEntity.SEQUENCE_BASE_GENERATOR
    }

    @Column(name = "name", nullable = false, length = 512)
    private var name: String ?= null

    @Column(name = "address", nullable = false, length = 512)
    private var address: String ?= null

    constructor() {}

    constructor(dateFrom: Date, dateTo: Date, name: String, address: String) : super(dateFrom, dateTo) {
        this.name = name
        this.address = address
    }

    fun getName(): String? {
        return name
    }

    fun setName(name: String) {
        this.name = name
    }

    fun getAddress(): String? {
        return address
    }

    fun setAddress(address: String) {
        this.address = address
    }
}