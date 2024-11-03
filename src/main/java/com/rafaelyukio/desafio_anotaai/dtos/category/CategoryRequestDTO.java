package com.rafaelyukio.desafio_anotaai.dtos.category;

import java.util.UUID;

public record CategoryRequestDTO(String title, String description, String ownerId) {
}
