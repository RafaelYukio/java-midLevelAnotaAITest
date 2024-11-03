package com.rafaelyukio.desafio_anotaai.services.product;

import com.rafaelyukio.desafio_anotaai.dtos.product.ProductRequestDTO;
import com.rafaelyukio.desafio_anotaai.dtos.product.ProductResponseDTO;

import java.util.List;

public interface IProductService {
    ProductResponseDTO create(ProductRequestDTO productRequestDTO) throws Exception;
    List<ProductResponseDTO> getAll();
    ProductResponseDTO getById(String id);
    ProductResponseDTO update(String id, ProductRequestDTO productRequestDTO);
    void delete(String id);
}
