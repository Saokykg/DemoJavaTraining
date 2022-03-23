package com.spring.demo.controller;

import com.spring.demo.pojos.Product;
import com.spring.demo.service.ICategoryService;
import com.spring.demo.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
public class ProductController {

    @Autowired
    private IProductService productService;

    @Autowired
    private ICategoryService categoryService;

    @GetMapping("/product")
    public ResponseEntity<List<Product>> getProduct(){
        List<Product> productList = this.productService.getFullList();
        return new ResponseEntity<>(productList, HttpStatus.OK);
    }

    @GetMapping("/product/{productId}")
    public ResponseEntity<Product> getById(@PathVariable(value = "productId") int productId){
        Product product = this.productService.getById(productId);
        return new ResponseEntity<>(product, HttpStatus.OK);
    }

//    @PostMapping("/product")
//    public ResponseEntity<Product> create(@Valid @RequestBody Product product){
//        return new ResponseEntity<>(this.productService.create(product), HttpStatus.CREATED);
//    }

    @PutMapping("/product")
    public ResponseEntity<Product> update(@Valid @RequestBody Product product){
        product.setCategory(this.categoryService.getById(product.getCate_id()));
        return new ResponseEntity<>(this.productService.update(product), HttpStatus.OK);
    }
}
