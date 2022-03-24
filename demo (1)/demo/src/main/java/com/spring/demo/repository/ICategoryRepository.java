package com.spring.demo.repository;

import com.spring.demo.DTO.Request.ProductRequestDTO;
import com.spring.demo.pojos.Category;
import com.spring.demo.pojos.Product;

import java.util.Collection;
import java.util.List;

public interface ICategoryRepository {
    public List<Category> getFullList();
    public Category getById(int id);
    public Category create(Category category);
    public Category update(Category category);
    public boolean delete(int id);
    public List<Product> getProduct(int id);
    public Product addProduct(Product product);
}
