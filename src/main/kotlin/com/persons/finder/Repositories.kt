package com.persons.finder

import com.persons.finder.data.Person
import com.persons.finder.data.Location
import org.springframework.data.repository.CrudRepository
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query

interface PersonRepository : CrudRepository<Person, Long> {}

interface LocationRepository: JpaRepository<Location, Long> {
    @Query(
        value = "SELECT * FROM LOCATION WHERE longitude >= ?1 AND longitude <= ?2 AND latitude >= ?3 AND latitude <= ?4",
        nativeQuery = true
    )
    fun findWithin(fromLongitude: Double, toLongitude: Double, fromLatitude: Double, toLatitude: Double): List<Location>
}