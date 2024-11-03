package com.rafaelyukio.desafio_anotaai.services.category;

import com.rafaelyukio.desafio_anotaai.dtos.category.CategoryRequestDTO;
import com.rafaelyukio.desafio_anotaai.dtos.category.CategoryResponseDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

public interface ICategoryService {
    CategoryResponseDTO create(CategoryRequestDTO categoryRequestDTO);
    List<CategoryResponseDTO> getAll();
    CategoryResponseDTO getById(String id) throws Exception;
    CategoryResponseDTO update(String id, CategoryRequestDTO categoryRequestDTO) throws Exception;
    void delete(String id);
}
