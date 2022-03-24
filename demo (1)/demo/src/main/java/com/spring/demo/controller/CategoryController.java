package com.spring.demo.controller;

import com.spring.demo.DTO.Mapping.ProductMapper;
import com.spring.demo.DTO.Request.CategoryRequestDTO;
import com.spring.demo.DTO.Request.ProductRequestDTO;
import com.spring.demo.DTO.Response.CategoryReponseDTO;
import com.spring.demo.DTO.Response.ProductReponseDTO;
import com.spring.demo.DTO.Response.ResponseDTO;
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
@RequestMapping("/api/v1")
public class CategoryController {

    @Autowired
    private ICategoryService categoryService;


    @PostMapping("/categories/get")
    public ResponseEntity<ResponseDTO> getProduct(){
        List<CategoryReponseDTO> categoryDtoList = this.categoryService.getFullList();

        ResponseDTO responseDTO  = new ResponseDTO(200, categoryDtoList);

        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    @PostMapping("/categories/{category_id}/get")
    public ResponseEntity<ResponseDTO> getById(@PathVariable(value = "category_id") int category_id){
        CategoryReponseDTO categoryDTO = this.categoryService.getById(category_id);
        ResponseDTO responseDTO  = new ResponseDTO(200, categoryDTO);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    @PostMapping("/categories/create")
    public ResponseEntity<ResponseDTO> create(@Valid @RequestBody CategoryRequestDTO dto){
        ResponseDTO responseDTO  = new ResponseDTO(200, this.categoryService.create(dto));
        return new ResponseEntity<>(responseDTO, HttpStatus.CREATED);
    }

    @PostMapping("/categories/{category_id}/update")
    public ResponseEntity<ResponseDTO> update(@PathVariable int category_id,
                            @Valid @RequestBody CategoryRequestDTO dto){
        dto.setId(category_id);
        ResponseDTO responseDTO = new ResponseDTO(200, this.categoryService.update(dto));
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }


    @PostMapping("/categories/{category_id}/products/get")
    public ResponseEntity<ResponseDTO> getProduct(@PathVariable int category_id){
        ResponseDTO responseDTO = new ResponseDTO(200, this.categoryService.getProduct(category_id));
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    @PostMapping("/categories/{category_id}/product/create")
    public ResponseEntity<ResponseDTO> addProduct(@PathVariable int category_id,
                                                        @Valid @RequestBody ProductRequestDTO product){
        product.setCategory_id(category_id);
        ProductReponseDTO dto = this.categoryService.addProduct(product);
        ResponseDTO responseDTO = new ResponseDTO(200, dto);
        return new ResponseEntity<>(responseDTO, HttpStatus.CREATED);
    }

}
