package com.rafaelyukio.desafio_anotaai.domain.product;

import com.rafaelyukio.desafio_anotaai.domain.category.Category;
import com.rafaelyukio.desafio_anotaai.dtos.product.ProductRequestDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;

@Document(collection = "products")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    @Id
    private String id;
    private String title;
    private String description;
    private String ownerId;
    private BigDecimal price;
    private Category category;

    public Product(ProductRequestDTO productRequestDTO) {
        this.title = productRequestDTO.title();
        this.description = productRequestDTO.description();
        this.ownerId = productRequestDTO.ownerId();
        this.price = productRequestDTO.price();
    }
}
