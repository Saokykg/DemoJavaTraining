package com.spring.demo.service;

import com.spring.demo.pojos.Category;
import com.spring.demo.pojos.Product;

import java.util.List;

public interface ICategoryService {
    public List<Category> getFullList();
    public Category getById(int id);
    public Category create(Category category);
    public Category update(Category category);
    public boolean delete(int id);
    public List<Product> getProduct(int id);
    public Product addProduct(Product product);
}
