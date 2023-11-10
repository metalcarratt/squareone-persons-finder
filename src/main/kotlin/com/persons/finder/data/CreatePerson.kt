package com.persons.finder.data
import com.fasterxml.jackson.annotation.JsonProperty

data class CreatePerson(
    @JsonProperty("name")
    val name: String
)
