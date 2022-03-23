package com.spring.demo.service.impl;

import com.spring.demo.pojos.Product;
import com.spring.demo.repository.IProductRepository;
import com.spring.demo.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ProductService implements IProductService {

    @Autowired
    private IProductRepository productRepository;

    @Override
    public List<Product> getByCategory(int id) {
        return this.productRepository.getByCategory(id);
    }

    @Override
    public List<Product> getFullList() {
        return this.productRepository.getFullList();
    }

    @Override
    public Product getById(int id) {
        return this.productRepository.getById(id);
    }

    @Override
    public Product create(Product product) {
        return this.productRepository.create(product);
    }

    @Override
    public Product update(Product product) {
        return this.productRepository.update(product);
    }

    @Override
    public Boolean delete(int id) {
        return this.productRepository.delete(id);
    }
}
