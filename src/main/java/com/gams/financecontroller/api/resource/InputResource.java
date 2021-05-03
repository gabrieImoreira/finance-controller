package com.gams.financecontroller.api.resource;

import com.gams.financecontroller.api.model.Input;
import com.gams.financecontroller.api.model.Person;
import com.gams.financecontroller.api.repository.InputRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/lancamentos")
public class InputResource {

    @Autowired
    InputRepository inputRepository;

    @GetMapping
    public List<Input> listAll(){
        return inputRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        Optional<Input> savedId  = inputRepository.findById(id);
        return !savedId.isEmpty() ? ResponseEntity.ok(savedId) : ResponseEntity.notFound().build();
    }
}
