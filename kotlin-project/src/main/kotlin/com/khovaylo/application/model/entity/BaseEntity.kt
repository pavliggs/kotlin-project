package com.khovaylo.application.model.entity

import org.springframework.data.util.ProxyUtils
import java.io.Serializable
import java.util.*
import javax.persistence.*

@MappedSuperclass
abstract class BaseEntity<T : Serializable> {

    companion object {
        const val SEQUENCE_BASE_GENERATOR = "base_generator"
    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SEQUENCE_BASE_GENERATOR)
    private var id: T? = null

    @Column(name = "date_from", nullable = false, columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    @Temporal(TemporalType.TIMESTAMP)
    private var dateFrom: Date? = null

    @Column(name = "date_to", nullable = true, columnDefinition="TIMESTAMP DEFAULT NULL")
    @Temporal(TemporalType.TIMESTAMP)
    private var dateTo: Date? = null

    constructor() {}

    constructor(dateFrom: Date, dateTo: Date) {
        this.dateFrom = dateFrom
        this.dateTo = dateTo
    }

    fun getId(): T? {
        return id
    }

    fun getDateFrom(): Date? {
        return dateFrom
    }

    fun setDateFrom(dateFrom: Date) {
        this.dateFrom = dateFrom
    }

    fun getDateTo(): Date? {
        return dateTo
    }

    fun setDateTo(dateTo: Date) {
        this.dateTo = dateTo
    }

    override fun equals(other: Any?): Boolean {
        if (other == null) return false

        if (this === other) return true

        if (javaClass != ProxyUtils.getUserClass(other)) return false

        other as BaseEntity<*>

        return if (null == this.getId()) false else this.getId() == other.getId()
    }

    override fun hashCode(): Int {
        return id?.hashCode() ?: 0
    }
}
