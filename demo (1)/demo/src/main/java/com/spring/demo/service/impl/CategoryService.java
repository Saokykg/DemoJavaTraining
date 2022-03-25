package com.spring.demo.service.impl;

import com.spring.demo.DTO.Mapping.CategoryMapper;
import com.spring.demo.DTO.Mapping.ProductMapper;
import com.spring.demo.DTO.Request.CategoryRequestDTO;
import com.spring.demo.DTO.Request.ProductRequestDTO;
import com.spring.demo.DTO.Response.CategoryReponseDTO;
import com.spring.demo.DTO.Response.ProductReponseDTO;
import com.spring.demo.pojos.Category;
import com.spring.demo.pojos.Product;
import com.spring.demo.repository.ICategoryRepository;
import com.spring.demo.repository.impl.CategoryRepository;
import com.spring.demo.service.ICategoryService;
import com.spring.demo.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class CategoryService implements ICategoryService {

    @Autowired
    private ICategoryRepository categoryRepository;


    @Override
    public List<CategoryReponseDTO> getFullList() {
        List<Category> categoryList = this.categoryRepository.getFullList();
        List<CategoryReponseDTO> dtoList = new ArrayList<>();
        categoryList.forEach(category -> {
            dtoList.add(CategoryMapper.getInstance().entityToDto(category));
        });
        return dtoList;
    }

    @Override
    public CategoryReponseDTO getById(int id) {
        CategoryReponseDTO dto = CategoryMapper.getInstance().entityToDto(this.categoryRepository.getById(id));
        return dto;
    }

    @Override
    public CategoryReponseDTO create(CategoryRequestDTO dto) {
        Category category = CategoryMapper.getInstance().dtoToEntity(dto);
        return CategoryMapper.getInstance().entityToDto(this.categoryRepository.create(category));
    }

    @Override
    public CategoryReponseDTO update(CategoryRequestDTO dto) {
        Category category = CategoryMapper.getInstance().dtoToEntity(dto);
        return CategoryMapper.getInstance().entityToDto(this.categoryRepository.update(category));
    }

    @Override
    public boolean delete(int id) {
        return this.categoryRepository.delete(id);
    }

    @Override
    public List<ProductReponseDTO> getProduct(int id) {
        List<Product> productList = this.categoryRepository.getProduct(id);
        List<ProductReponseDTO> dtoList = new ArrayList<>();
        productList.forEach(product -> {
            dtoList.add(ProductMapper.getInstance().entityToDto(product));
        });
        return dtoList;
    }

    @Override
    public ProductReponseDTO addProduct(ProductRequestDTO dto) {

        Product product = ProductMapper.getInstance().dtoToEntity(dto);
        product.setCategory(this.categoryRepository.getById(dto.getCategory_id()));
        
        return ProductMapper.getInstance().entityToDto(this.categoryRepository.addProduct(product));
    }
}
