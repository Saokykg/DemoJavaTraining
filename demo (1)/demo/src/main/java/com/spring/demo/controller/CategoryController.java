package com.spring.demo.controller;

import com.spring.demo.pojos.Category;
import com.spring.demo.service.ICategoryService;
import com.spring.demo.service.impl.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class CategoryController {

    @Autowired
    private ICategoryService categoryService;

    @GetMapping("/category")
    public ResponseEntity<List<Category>> getCategoryList(){
        return new ResponseEntity<>(this.categoryService.getFullList(), HttpStatus.OK);
    }
}
