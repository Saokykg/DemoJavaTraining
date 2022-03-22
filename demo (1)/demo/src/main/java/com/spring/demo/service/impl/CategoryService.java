package com.spring.demo.service.impl;

import com.spring.demo.pojos.Category;
import com.spring.demo.repository.ICategoryRepository;
import com.spring.demo.repository.impl.CategoryRepository;
import com.spring.demo.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CategoryService implements ICategoryService {

    @Autowired
    private ICategoryRepository categoryRepository;

    @Override
    public List<Category> getFullList() {
        return this.categoryRepository.getFullList();
    }

    @Override
    public Category getById() {
        return this.categoryRepository.getById();
    }
}
