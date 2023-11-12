package com.persons.finder

import com.persons.finder.data.Person
import com.persons.finder.data.Location
import org.springframework.data.repository.CrudRepository
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query

interface PersonRepository : CrudRepository<Person, Long> {}

interface LocationRepository: JpaRepository<Location, Long> {
    @Query(
        value = "SELECT * FROM LOCATION WHERE (POWER(ABS(longitude - ?1), 2) + POWER(ABS(latitude - ?2), 2)) <= ?3",
        nativeQuery = true
    )
    fun findWithin(long: Double, lat: Double, range: Double): List<Location>
}