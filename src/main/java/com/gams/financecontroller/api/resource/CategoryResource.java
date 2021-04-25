package com.gams.financecontroller.api.resource;

import com.gams.financecontroller.api.model.Category;
import com.gams.financecontroller.api.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletResponse;
import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/categorias")
public class CategoryResource {

    @Autowired
    CategoryRepository categoryRepository;

    @GetMapping
    public List<Category> listAll(){
       return categoryRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<Category> create(@RequestBody Category category, HttpServletResponse response){
        Category savedCategory = categoryRepository.save(category);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}")
                .buildAndExpand(savedCategory.getId()).toUri();
        response.setHeader("Location", uri.toASCIIString());

        return ResponseEntity.created(uri).body(savedCategory);
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id){
        Optional<Category> savedId = categoryRepository.findById(id);

        return !savedId.isEmpty() ? ResponseEntity.ok(savedId) : ResponseEntity.notFound().build();
    }
}
