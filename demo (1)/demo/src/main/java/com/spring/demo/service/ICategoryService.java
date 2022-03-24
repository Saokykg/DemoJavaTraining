package com.spring.demo.service;

import com.spring.demo.DTO.Request.CategoryRequestDTO;
import com.spring.demo.DTO.Request.ProductRequestDTO;
import com.spring.demo.DTO.Response.CategoryReponseDTO;
import com.spring.demo.DTO.Response.ProductReponseDTO;
import com.spring.demo.pojos.Category;
import com.spring.demo.pojos.Product;

import java.util.List;

public interface ICategoryService {
    public List<CategoryReponseDTO> getFullList();
    public CategoryReponseDTO getById(int id);
    public CategoryReponseDTO create(CategoryRequestDTO dto);
    public CategoryReponseDTO update(CategoryRequestDTO dto);
    public boolean delete(int id);
    public List<ProductReponseDTO> getProduct(int id);
    public ProductReponseDTO addProduct(ProductRequestDTO product);
}
