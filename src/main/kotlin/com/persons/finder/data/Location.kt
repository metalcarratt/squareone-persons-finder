package com.persons.finder.data

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id


@Entity
data class Location(
    @Column
    val referenceId: Long,

    @Column
    val latitude: Double,

    @Column
    val longitude: Double,

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null
)
