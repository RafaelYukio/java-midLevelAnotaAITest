package com.rafaelyukio.desafio_anotaai.dtos.product;

import com.rafaelyukio.desafio_anotaai.dtos.category.CategoryResponseDTO;

import java.io.Serializable;
import java.math.BigDecimal;

public record ProductResponseDTO(String id, String title, String description, String ownerId, BigDecimal price, CategoryResponseDTO category) {

}