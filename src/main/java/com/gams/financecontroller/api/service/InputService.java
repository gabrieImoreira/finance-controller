package com.gams.financecontroller.api.service;

import com.gams.financecontroller.api.model.Input;
import com.gams.financecontroller.api.model.Person;
import com.gams.financecontroller.api.repository.InputRepository;
import com.gams.financecontroller.api.service.exception.PersonNonEnexistentOrInactiveExpection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InputService {

    @Autowired
    private PersonService personService;

    @Autowired
    private InputRepository inputRepository;


    public Input save(Input input) {
        Person person = personService.search(input.getPerson().getId());
        if(person == null || person.isInactive()) {
            throw new PersonNonEnexistentOrInactiveExpection();
        }
        return inputRepository.save(input);
    }
}
