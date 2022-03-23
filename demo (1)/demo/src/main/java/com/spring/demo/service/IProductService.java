package com.spring.demo.service;

import com.spring.demo.pojos.Product;

import java.util.List;

public interface IProductService {
    List<Product> getByCategory(int id);
    List<Product> getFullList();
    Product getById(int id);
    Product create(Product product);
    Product update(Product product);
    Boolean delete(int id);
}
