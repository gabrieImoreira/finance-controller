package com.gams.financecontroller.api.resource;

import com.gams.financecontroller.api.event.ResourceCreatedEvent;
import com.gams.financecontroller.api.model.Input;
import com.gams.financecontroller.api.model.Person;
import com.gams.financecontroller.api.repository.InputRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/lancamentos")
public class InputResource {

    @Autowired
    InputRepository inputRepository;

    @Autowired
    private ApplicationEventPublisher publisher;

    @GetMapping
    public List<Input> listAll(){
        return inputRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        Optional<Input> savedId  = inputRepository.findById(id);
        return !savedId.isEmpty() ? ResponseEntity.ok(savedId) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Input> create(@Valid @RequestBody Input input, HttpServletResponse response){
        Input savedInput = inputRepository.save(input);
        publisher.publishEvent(new ResourceCreatedEvent(this, response, savedInput.getId())); 
        return ResponseEntity.status(HttpStatus.CREATED).body(savedInput);
    }

}
