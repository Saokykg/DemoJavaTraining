package com.spring.demo.repository;

import com.spring.demo.pojos.Category;

import java.util.List;

public interface ICategoryRepository {
    public List<Category> getFullList();
    public Category getById();
}
