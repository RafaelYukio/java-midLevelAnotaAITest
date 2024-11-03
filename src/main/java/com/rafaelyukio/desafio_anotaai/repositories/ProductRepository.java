package com.rafaelyukio.desafio_anotaai.repositories;

import com.rafaelyukio.desafio_anotaai.domain.product.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

public interface ProductRepository extends MongoRepository<Product, String> {
}
