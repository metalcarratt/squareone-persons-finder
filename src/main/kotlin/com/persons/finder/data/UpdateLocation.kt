package com.persons.finder.data
import com.fasterxml.jackson.annotation.JsonProperty

data class UpdateLocation(
    @JsonProperty("latitude")
    val latitude: Double,

    @JsonProperty("longitude")
    val longitude: Double
)
