package com.spring.demo.controller;

import com.spring.demo.DTO.Mapping.ProductMapper;
import com.spring.demo.DTO.Request.ProductRequestDTO;
import com.spring.demo.DTO.Response.ProductReponseDTO;
import com.spring.demo.DTO.Response.ResponseDTO;
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
@RequestMapping("/api/v1")
public class ProductController {

    @Autowired
    private IProductService productService;

    @Autowired
    private ICategoryService categoryService;

    @PostMapping("/products/get")
    public ResponseEntity<ResponseDTO> getProduct(){
        List<ProductReponseDTO> dtoList = this.productService.getFullList();
        ResponseDTO responseDTO = new ResponseDTO(200, dtoList);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    @PostMapping("/products/{productId}/get")
    public ResponseEntity<ResponseDTO> getById(@PathVariable int productId){
        ProductReponseDTO productDTO = this.productService.getById(productId);
        ResponseDTO responseDTO = new ResponseDTO(200, productDTO);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    @PostMapping("/products/create")
    public ResponseEntity<ResponseDTO> create(@Valid @RequestBody ProductRequestDTO product){
        ProductReponseDTO productDTO = this.productService.create(product);
        ResponseDTO responseDTO = new ResponseDTO(200, productDTO);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    @PostMapping("/products/{productId}/update")
    public ResponseEntity<ResponseDTO> update(@PathVariable int productId,
            @Valid @RequestBody ProductRequestDTO product){
        product.setId(productId);
        ProductReponseDTO productDTO = this.productService.update(product);
        ResponseDTO responseDTO = new ResponseDTO(200, productDTO);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }
}
