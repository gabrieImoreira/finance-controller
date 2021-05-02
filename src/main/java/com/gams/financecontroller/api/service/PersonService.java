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

    public Person search(Long id){
        try {
            Person savedPerson = personRepository.findById(id).get();
            return savedPerson;
        }catch (NoSuchElementException ex) {
            throw new EmptyResultDataAccessException(1);
        }
    }

    public Person update(Person person, Long id) {
        Person savedPerson = search(id);
        BeanUtils.copyProperties(person, savedPerson, "id");
        return personRepository.save(savedPerson);
    }

    public void attPropertyActive(Long id, Boolean active) {
        Person savedPerson = search(id);
        savedPerson.setActive(active);
        personRepository.save(savedPerson);
    }
}
