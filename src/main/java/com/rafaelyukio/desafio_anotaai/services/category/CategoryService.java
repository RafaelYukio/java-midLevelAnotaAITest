package com.rafaelyukio.desafio_anotaai.services.category;

import com.rafaelyukio.desafio_anotaai.domain.category.Category;
import com.rafaelyukio.desafio_anotaai.dtos.category.CategoryRequestDTO;
import com.rafaelyukio.desafio_anotaai.dtos.category.CategoryResponseDTO;
import com.rafaelyukio.desafio_anotaai.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CategoryService implements ICategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    public CategoryResponseDTO create(CategoryRequestDTO categoryRequestDTO) {
        Category category = new Category(categoryRequestDTO);
        categoryRepository.save(category);
        return new CategoryResponseDTO(category.getId(), category.getTitle(), category.getDescription(), category.getOwnerId());
    }

    public List<CategoryResponseDTO> getAll() {
        return categoryRepository.findAll().stream()
                .map(c -> new CategoryResponseDTO(c.getId(), c.getTitle(), c.getDescription(), c.getOwnerId()))
                .toList();
    }

    public CategoryResponseDTO getById(String id) throws Exception {
        Category category = categoryRepository.findById(id).orElseThrow(() -> new Exception("Category not found!"));
        return new CategoryResponseDTO(category.getId(), category.getTitle(), category.getDescription(), category.getOwnerId());
    }

    public CategoryResponseDTO update(String id, CategoryRequestDTO categoryRequestDTO) throws Exception {
        Category category = categoryRepository.findById(id).orElseThrow(() -> new Exception("Category not found!"));

        category.setDescription(categoryRequestDTO.description());
        category.setTitle(categoryRequestDTO.title());
        category.setOwnerId(categoryRequestDTO.ownerId());

        categoryRepository.save(category);
        return new CategoryResponseDTO(category.getId(), category.getTitle(), category.getDescription(), category.getOwnerId());
    }

    public void delete(String id) {
        categoryRepository.deleteById(id);
    }
}
