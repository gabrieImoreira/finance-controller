package com.gams.financecontroller.api.resource;

import com.gams.financecontroller.api.event.ResourceCreatedEvent;
import com.gams.financecontroller.api.model.Person;
import com.gams.financecontroller.api.repository.PersonRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@RestController
@RequestMapping("/pessoas")
public class PersonResource {

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private ApplicationEventPublisher publisher;

    @GetMapping
    public List<Person> listAll(){
        return personRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        Optional<Person> savedId  = personRepository.findById(id);
        return !savedId.isEmpty() ? ResponseEntity.ok(savedId) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Person> create(@Valid @RequestBody Person person, HttpServletResponse response){
        Person savedPerson = personRepository.save(person);
        publisher.publishEvent(new ResourceCreatedEvent(this, response, savedPerson.getId())); //event -> explication at my private git ;)
        return ResponseEntity.status(HttpStatus.CREATED).body(savedPerson);
    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        personRepository.deleteById(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> att(@PathVariable Long id, @Valid @RequestBody Person person) {
        try {
            Person savedPerson = personRepository.findById(id).get();
            BeanUtils.copyProperties(person, savedPerson, "id");
            personRepository.save(savedPerson);
            return ResponseEntity.ok(savedPerson);
        }catch (NoSuchElementException ex) {
            throw new EmptyResultDataAccessException(1);
        }
    }
}
