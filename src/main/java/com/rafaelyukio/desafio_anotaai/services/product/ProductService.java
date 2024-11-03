package com.rafaelyukio.desafio_anotaai.services.product;

import com.rafaelyukio.desafio_anotaai.domain.category.Category;
import com.rafaelyukio.desafio_anotaai.domain.category.exceptions.CategoryNotFoundException;
import com.rafaelyukio.desafio_anotaai.domain.product.Product;
import com.rafaelyukio.desafio_anotaai.domain.product.exceptions.ProductNotFoundException;
import com.rafaelyukio.desafio_anotaai.dtos.category.CategoryResponseDTO;
import com.rafaelyukio.desafio_anotaai.dtos.product.ProductRequestDTO;
import com.rafaelyukio.desafio_anotaai.dtos.product.ProductResponseDTO;
import com.rafaelyukio.desafio_anotaai.repositories.CategoryRepository;
import com.rafaelyukio.desafio_anotaai.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService implements IProductService {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public ProductResponseDTO create(ProductRequestDTO productRequestDTO) throws Exception {
        Category category = categoryRepository.findById(productRequestDTO.categoryId()).orElseThrow(CategoryNotFoundException::new);

        Product product = new Product(productRequestDTO);
        product.setCategory(category);

        CategoryResponseDTO categoryResponseDTO = new CategoryResponseDTO(category.getId(), category.getTitle(), category.getDescription(), category.getOwnerId());

        productRepository.save(product);
        return new ProductResponseDTO(product.getId(), product.getTitle(), product.getDescription(), product.getOwnerId(), product.getPrice(), categoryResponseDTO);
    }

    @Override
    public List<ProductResponseDTO> getAll() {
        return productRepository.findAll().stream()
            .map(p -> {
                CategoryResponseDTO categoryResponseDTO = new CategoryResponseDTO(p.getCategory().getId(),
                                                                                  p.getCategory().getTitle(),
                                                                                  p.getCategory().getDescription(),
                                                                                  p.getCategory().getOwnerId());
                return new ProductResponseDTO(p.getId(), p.getTitle(), p.getDescription(), p.getOwnerId(), p.getPrice(), categoryResponseDTO);
            }).toList();
    }

    @Override
    public ProductResponseDTO getById(String id) {
        Product product = productRepository.findById(id).orElseThrow(ProductNotFoundException::new);
        CategoryResponseDTO categoryResponseDTO = new CategoryResponseDTO(product.getCategory().getId(),
                                                                          product.getCategory().getTitle(),
                                                                          product.getCategory().getDescription(),
                                                                          product.getCategory().getOwnerId());

        return new ProductResponseDTO(product.getId(), product.getTitle(), product.getDescription(), product.getOwnerId(), product.getPrice(), categoryResponseDTO);
    }

    @Override
    public ProductResponseDTO update(String id, ProductRequestDTO productRequestDTO) {
        Product product = productRepository.findById(id).orElseThrow(ProductNotFoundException::new);
        Category category = categoryRepository.findById(productRequestDTO.categoryId()).orElseThrow(CategoryNotFoundException::new);

        product.setCategory(category);
        product.setPrice(productRequestDTO.price());
        product.setTitle(productRequestDTO.title());
        product.setDescription(productRequestDTO.description());
        product.setOwnerId(productRequestDTO.ownerId());

        productRepository.save(product);
        CategoryResponseDTO categoryResponseDTO = new CategoryResponseDTO(category.getId(), category.getTitle(), category.getDescription(), category.getOwnerId());
        return new ProductResponseDTO(product.getId(), product.getTitle(), product.getDescription(), product.getOwnerId(), product.getPrice(), categoryResponseDTO);
    }

    @Override
    public void delete(String id) {
        productRepository.deleteById(id);
    }
}
