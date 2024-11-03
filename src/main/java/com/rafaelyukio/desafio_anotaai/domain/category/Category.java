package com.rafaelyukio.desafio_anotaai.domain.category;

import com.rafaelyukio.desafio_anotaai.dtos.category.CategoryRequestDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "categories")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Category {
    @Id
    private String id;
    private String title;
    private String description;
    private String ownerId;

    public Category(CategoryRequestDTO categoryRequestDTO) {
        this.title = categoryRequestDTO.title();
        this.description = categoryRequestDTO.description();
        this.ownerId = categoryRequestDTO.ownerId();
    }
}
