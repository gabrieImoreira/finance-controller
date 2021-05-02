package com.gams.financecontroller.api.service;

import com.gams.financecontroller.api.model.Category;
import com.gams.financecontroller.api.repository.CategoryRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class CategoryService {

    @Autowired
    CategoryRepository categoryRepository;

    public Category update(Category category, Long id) {
        try {
            Category savedCategory = categoryRepository.findById(id).get();
            BeanUtils.copyProperties(category, savedCategory, "id");
            return categoryRepository.save(savedCategory);
        } catch (NoSuchElementException ex) {
            throw new EmptyResultDataAccessException(1);
        }
    }
}
