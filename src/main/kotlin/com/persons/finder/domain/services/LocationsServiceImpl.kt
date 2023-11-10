package com.persons.finder.domain.services

import com.persons.finder.data.Location
import com.persons.finder.LocationRepository
import org.springframework.stereotype.Service
import org.springframework.beans.factory.annotation.Autowired

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
        val dist = radiusInKm; //kmToLongLat(radiusInKm);

        return repository.findWithin(
            longitude - dist,
            longitude + dist,
            latitude - dist,
            latitude + dist
        ).map({ it.referenceId })
    }

    fun kmToLongLat(km: Double): Double {
        return km / 111;
    }
}