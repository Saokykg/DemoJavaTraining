package com.spring.demo.controller;

import com.spring.demo.pojos.Category;
import com.spring.demo.pojos.Product;
import com.spring.demo.service.ICategoryService;
import com.spring.demo.service.impl.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
public class CategoryController {

    @Autowired
    private ICategoryService categoryService;

    @GetMapping("/category")
    public ResponseEntity<List<Category>> getProduct(){
        List<Category> categoryList = this.categoryService.getFullList();
        return new ResponseEntity<>(categoryList, HttpStatus.OK);
    }

    @GetMapping("/category/{category_id}")
    public ResponseEntity<Category> getById(@PathVariable(value = "category_id") int category_id){
        Category category = this.categoryService.getById(category_id);
        return new ResponseEntity<>(category, HttpStatus.OK);
    }

    @PostMapping("/category")
    public ResponseEntity<Category> create(@Valid @RequestBody Category category){
        return new ResponseEntity<>(this.categoryService.create(category), HttpStatus.CREATED);
    }


    @PutMapping("/category")
    public ResponseEntity<Category> update(@Valid @RequestBody Category category){
        return new ResponseEntity<>(this.categoryService.update(category), HttpStatus.OK);
    }


    @GetMapping("/category/{category_id}/product")
    public ResponseEntity<List<Product>> getProduct(@PathVariable int category_id){
        return new ResponseEntity<>(this.categoryService.getProduct(category_id), HttpStatus.OK);
    }

    @PostMapping("/category/{category_id}/product")
    public ResponseEntity<Product> addProduct(@PathVariable int category_id,
                                              @Valid @RequestBody Product product){
        product.setCategory(this.categoryService.getById(category_id));
        return new ResponseEntity<>(this.categoryService.addProduct(product), HttpStatus.CREATED);
    }

}
