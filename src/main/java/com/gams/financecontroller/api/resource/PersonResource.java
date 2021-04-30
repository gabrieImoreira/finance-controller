package com.gams.financecontroller.api.resource;

import com.gams.financecontroller.api.model.Category;
import com.gams.financecontroller.api.model.Person;
import com.gams.financecontroller.api.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/pessoas")
public class PersonResource {

    @Autowired
    private PersonRepository personRepository;

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

        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}")
                .buildAndExpand(savedPerson.getId()).toUri();
        response.setHeader("Location", uri.toASCIIString());

        return ResponseEntity.created(uri).body(savedPerson);
    }
}
