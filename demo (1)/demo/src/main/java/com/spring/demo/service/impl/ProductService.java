package com.spring.demo.service.impl;

import com.spring.demo.DTO.Mapping.ProductMapper;
import com.spring.demo.DTO.Request.ProductRequestDTO;
import com.spring.demo.DTO.Response.ProductReponseDTO;
import com.spring.demo.pojos.Product;
import com.spring.demo.repository.ICategoryRepository;
import com.spring.demo.repository.IProductRepository;
import com.spring.demo.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class ProductService implements IProductService {

    @Autowired
    private IProductRepository productRepository;

    @Autowired
    private ICategoryRepository categoryRepository;

    @Override
    public List<ProductReponseDTO> getByCategory(int id) {
        List<Product> productList = this.productRepository.getByCategory(id);
        List<ProductReponseDTO> dtoList = new ArrayList<>();
        productList.forEach(product -> {
            dtoList.add(ProductMapper.getInstance().entityToDto(product));
        });
        return dtoList;
    }

    @Override
    public List<ProductReponseDTO> getFullList() {
        List<Product> productList = this.productRepository.getFullList();
        List<ProductReponseDTO> dtoList = new ArrayList<>();
        productList.forEach(product -> {
            dtoList.add(ProductMapper.getInstance().entityToDto(product));
        });
        return dtoList;
    }

    @Override
    public ProductReponseDTO getById(int id) {
        return ProductMapper.getInstance().entityToDto(this.productRepository.getById(id));
    }

    @Override
    public ProductReponseDTO create(ProductRequestDTO dto) {
        Product product = ProductMapper.getInstance().dtoToEntity(dto);
        product.setCategory(this.categoryRepository.getById(dto.getCategory_id()));

        return ProductMapper.getInstance().entityToDto(this.productRepository.create(product));
    }

    @Override
    public ProductReponseDTO update(ProductRequestDTO dto) {
        Product product = ProductMapper.getInstance().dtoToEntity(dto);
        product.setCategory(this.categoryRepository.getById(dto.getCategory_id()));
        return ProductMapper.getInstance().entityToDto(this.productRepository.update(product));
    }

    @Override
    public Boolean delete(int id) {
        return this.productRepository.delete(id);
    }
}
