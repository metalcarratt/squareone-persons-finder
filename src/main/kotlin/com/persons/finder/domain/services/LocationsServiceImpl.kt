package com.persons.finder.domain.services

import com.persons.finder.data.Location
import com.persons.finder.LocationRepository
import org.springframework.stereotype.Service
import org.springframework.beans.factory.annotation.Autowired

const val KM_IN_LONG_LAT = 111;

@Service
class LocationsServiceImpl : LocationsService {

    @Autowired
    private lateinit var repository: LocationRepository;

    override fun addLocation(location: Location): Location {
        return repository.save(location);
    }

    override fun removeLocation(locationReferenceId: Long) {
        TODO("Not yet implemented")
    }

    override fun findAround(latitude: Double, longitude: Double, radiusInKm: Double): List<Long> {
        return repository.findWithin(
            longitude,
            latitude,
            Math.pow(radiusInKm / KM_IN_LONG_LAT, 2.0)
        ).map({ it.referenceId })
    }
}