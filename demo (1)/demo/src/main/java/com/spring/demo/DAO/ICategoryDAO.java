package com.spring.demo.DAO;

import com.spring.demo.pojos.Category;

public interface ICategoryDAO {
    Category get(int id);
    boolean create(Category category);
    boolean update(Category category);
    boolean delete(int id);
}
