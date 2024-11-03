package com.rafaelyukio.desafio_anotaai.repositories;

import com.rafaelyukio.desafio_anotaai.domain.category.Category;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

public interface CategoryRepository extends MongoRepository<Category, String> {
}
