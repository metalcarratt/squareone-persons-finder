package com.persons.finder.presentation

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestParam

import com.persons.finder.data.CreatePerson
import com.persons.finder.data.Person
import com.persons.finder.data.Location
import com.persons.finder.data.UpdateLocation
import com.persons.finder.domain.services.PersonsService
import com.persons.finder.domain.services.LocationsService

@RestController
@RequestMapping("api/v1/persons")
class PersonController @Autowired constructor() {

    @Autowired
    private lateinit var personsService: PersonsService

    @Autowired
    private lateinit var locationsService: LocationsService

    /*
        PUT API to update/create someone's location using latitude and longitude
        (JSON) Body
     */
    @PutMapping("{id}/location")
    fun updatePersonLocation(
        @PathVariable id: Long,
        @RequestBody location: UpdateLocation
    ): Location {
        val location = Location(id, location.latitude, location.longitude)
        return locationsService.addLocation(location)
    }

    /*
        POST API to create a 'person'
        (JSON) Body and return the id of the created entity
    */
    @PostMapping("")
    fun createPerson(@RequestBody person: CreatePerson): Person {
        return personsService.save(person.name)
    }

    /*
        GET API to retrieve people around query location with a radius in KM, Use query param for radius.
        API just return a list of persons ids (JSON)
        // Example
        // John wants to know who is around his location within a radius of 10km
        // API would be called using John's id and a radius 10km
     */
    @GetMapping("/location")
    fun queryLocation(
        @RequestParam latitude: Double,
        @RequestParam longitude: Double,
        @RequestParam distance: Double
    ): List<Long> {
        return locationsService.findAround(latitude, longitude, distance)
    }

    /*
        GET API to retrieve a person or persons name using their ids
        // Example
        // John has the list of people around them, now they need to retrieve everybody's names to display in the app
        // API would be called using person or persons ids
     */
    @GetMapping("")
    fun getPerson(@RequestParam id: List<Long>): List<Person> {
        return id.map({ personsService.getById(it) })
    }

}