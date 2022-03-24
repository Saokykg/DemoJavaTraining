package com.spring.demo.DAO;

import com.spring.demo.pojos.Product;

public interface IProductDAO {
    Product get(int id);
    boolean create(Product product);
    boolean update(Product product);
    boolean delete(int id);
}
