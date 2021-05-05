package com.gams.financecontroller.api.resource;

import com.gams.financecontroller.api.event.ResourceCreatedEvent;
import com.gams.financecontroller.api.exception.FinanceControllerExceptionHandler;
import com.gams.financecontroller.api.model.Input;
import com.gams.financecontroller.api.repository.InputRepository;
import com.gams.financecontroller.api.repository.filter.FilterInput;
import com.gams.financecontroller.api.service.InputService;
import com.gams.financecontroller.api.service.exception.PersonNonEnexistentOrInactiveExpection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/lancamentos")
public class InputResource {

    @Autowired
    InputService service;

    @Autowired
    InputRepository inputRepository;

    @Autowired
    private ApplicationEventPublisher publisher;

    @GetMapping
    public List<Input> search(FilterInput filterInput){
        return inputRepository.filter(filterInput);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        Optional<Input> savedId  = inputRepository.findById(id);
        return !savedId.isEmpty() ? ResponseEntity.ok(savedId) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Input> create(@Valid @RequestBody Input input, HttpServletResponse response){
        Input savedInput = service.save(input);
        publisher.publishEvent(new ResourceCreatedEvent(this, response, savedInput.getId()));
        return ResponseEntity.status(HttpStatus.CREATED).body(savedInput);
    }

    @ExceptionHandler({PersonNonEnexistentOrInactiveExpection.class})
    public ResponseEntity<?> handlePersonNonEnexistentOrInactiveExpection(PersonNonEnexistentOrInactiveExpection ex, WebRequest request) {
        String msgUser = "Pessoa inexistente ou inativa";
        String msgDev =ex.toString();
        List<FinanceControllerExceptionHandler.Error> errors = Arrays.asList(new FinanceControllerExceptionHandler.Error(msgUser, msgDev));
        return ResponseEntity.badRequest().body(errors);
    }

}
