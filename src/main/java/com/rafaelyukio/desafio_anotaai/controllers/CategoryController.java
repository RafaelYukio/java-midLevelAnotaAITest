package com.rafaelyukio.desafio_anotaai.controllers;

import com.rafaelyukio.desafio_anotaai.dtos.category.CategoryRequestDTO;
import com.rafaelyukio.desafio_anotaai.dtos.category.CategoryResponseDTO;
import com.rafaelyukio.desafio_anotaai.services.category.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/category")
public class CategoryController {
    @Autowired
    private ICategoryService categoryService;

    @PostMapping
    public ResponseEntity<CategoryResponseDTO> Create(@RequestBody CategoryRequestDTO category) {
        CategoryResponseDTO response = categoryService.create(category);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<CategoryResponseDTO>> getAll() {
        List<CategoryResponseDTO> response = categoryService.getAll();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoryResponseDTO> getById(@PathVariable String id) throws Exception {
        CategoryResponseDTO response = categoryService.getById(id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
