package com.spring.demo.service;

import com.spring.demo.pojos.Category;

import java.util.List;

public interface ICategoryService {
    public List<Category> getFullList();
    public Category getById();
}
