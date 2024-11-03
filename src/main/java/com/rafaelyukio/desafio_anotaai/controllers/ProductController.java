package com.rafaelyukio.desafio_anotaai.controllers;

import com.rafaelyukio.desafio_anotaai.dtos.product.ProductRequestDTO;
import com.rafaelyukio.desafio_anotaai.dtos.product.ProductResponseDTO;
import com.rafaelyukio.desafio_anotaai.services.product.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {
    @Autowired
    private IProductService productService;

    @PostMapping
    public ResponseEntity<ProductResponseDTO> create(ProductRequestDTO productRequestDTO) throws Exception {
        ProductResponseDTO response = productService.create(productRequestDTO);
        return new ResponseEntity<ProductResponseDTO>(response, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<ProductResponseDTO>> getAll() throws Exception {
        List<ProductResponseDTO> response = productService.getAll();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductResponseDTO> getById(@PathVariable String id) throws Exception {
        ProductResponseDTO response = productService.getById(id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductResponseDTO> update(@PathVariable String id, ProductRequestDTO productRequestDTO) throws Exception {
        ProductResponseDTO response = productService.update(id, productRequestDTO);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ProductResponseDTO> delete(@PathVariable String id) throws Exception {
        productService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
