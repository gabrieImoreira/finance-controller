package com.gams.financecontroller.api.resource;

import com.gams.financecontroller.api.event.ResourceCreatedEvent;
import com.gams.financecontroller.api.model.Category;
import com.gams.financecontroller.api.repository.CategoryRepository;
import com.gams.financecontroller.api.service.CategoryService;
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
@RequestMapping("/categorias")
public class CategoryResource {

    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    private ApplicationEventPublisher publisher;

    @Autowired
    private CategoryService service;

    @GetMapping
    public List<Category> listAll(){
       return categoryRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<Category> create(@Valid @RequestBody Category category, HttpServletResponse response){
        Category savedCategory = categoryRepository.save(category);
        publisher.publishEvent(new ResourceCreatedEvent(this, response, savedCategory.getId())); //event -> explication at my private git ;)
        return ResponseEntity.status(HttpStatus.CREATED).body(savedCategory);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id){
        Optional<Category> savedId = categoryRepository.findById(id);

        return !savedId.isEmpty() ? ResponseEntity.ok(savedId) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        categoryRepository.deleteById(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> att(@PathVariable Long id, @Valid @RequestBody Category category) {
        Category savedCategory = service.update(category, id);
        return ResponseEntity.ok(savedCategory);
    }
}
