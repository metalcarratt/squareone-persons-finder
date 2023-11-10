package com.persons.finder.domain.services

import com.persons.finder.data.Person
import org.springframework.stereotype.Service
import com.persons.finder.PersonRepository
import org.springframework.beans.factory.annotation.Autowired

@Service
class PersonsServiceImpl : PersonsService {

    @Autowired
    private lateinit var repository: PersonRepository;

    override fun getById(id: Long): Person {
        return repository.findById(id).get();
    }

    override fun save(name: String): Person {
        var createdPerson = Person(name)
        return repository.save(createdPerson);
    }

}