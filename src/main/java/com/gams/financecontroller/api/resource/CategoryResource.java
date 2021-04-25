package com.gams.financecontroller.api.resource;

import com.gams.financecontroller.api.model.Category;
import com.gams.financecontroller.api.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/categorias")
public class CategoryResource {

    @Autowired
    CategoryRepository categoryRepository;

    @GetMapping
    public List<Category> listAll(){
       return categoryRepository.findAll();
    }

}
