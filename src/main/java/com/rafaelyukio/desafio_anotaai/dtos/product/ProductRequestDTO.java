package com.rafaelyukio.desafio_anotaai.dtos.product;

import java.math.BigDecimal;

public record ProductRequestDTO(String title, String description, String ownerId, BigDecimal price, String categoryId) {
}
