package com.spring.demo.repository;

import com.spring.demo.pojos.Product;

import java.util.List;

public interface IProductRepository {
    List<Product> getByCategory(int id);
    List<Product> getFullList();
    Product getById(int id);
    Product create(Product product);
    Product update(Product product);
    Boolean delete(int id);
    Boolean changeCate(int id);
}
