package com.rafaelyukio.desafio_anotaai.dtos.category;

import java.util.UUID;

public record CategoryResponseDTO(String id, String title, String description, String ownerId) {
}
