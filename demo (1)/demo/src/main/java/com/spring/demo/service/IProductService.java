package com.spring.demo.service;

import com.spring.demo.DTO.Request.ProductRequestDTO;
import com.spring.demo.DTO.Response.ProductReponseDTO;
import com.spring.demo.pojos.Product;

import java.util.List;

public interface IProductService {
    List<ProductReponseDTO> getByCategory(int id);
    List<ProductReponseDTO> getFullList();
    ProductReponseDTO getById(int id);
    ProductReponseDTO create(ProductRequestDTO product);
    ProductReponseDTO update(ProductRequestDTO product);
    Boolean delete(int id);
}
