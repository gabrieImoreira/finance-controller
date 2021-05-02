package com.gams.financecontroller.api.service;

import com.gams.financecontroller.api.model.Person;
import com.gams.financecontroller.api.repository.PersonRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    public Person update(Person person, Long id) {
        try {
            Person savedPerson = personRepository.findById(id).get();
            BeanUtils.copyProperties(person, savedPerson, "id");
            return personRepository.save(savedPerson);
        }catch (NoSuchElementException ex) {
            throw new EmptyResultDataAccessException(1);
        }

    }
}
