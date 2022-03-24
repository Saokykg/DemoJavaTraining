package com.spring.demo.DTO.Mapping;

import com.spring.demo.DAO.ICategoryDAO;
import com.spring.demo.DAO.impl.CategoryDAO;
import com.spring.demo.DTO.Request.CategoryRequestDTO;
import com.spring.demo.DTO.Request.ProductRequestDTO;
import com.spring.demo.DTO.Response.CategoryReponseDTO;
import com.spring.demo.DTO.Response.ProductReponseDTO;
import com.spring.demo.pojos.Category;
import com.spring.demo.pojos.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
public class ProductMapper {
    private static ProductMapper INSTANCE;

    @Autowired
    ICategoryDAO categoryDAO;

    public static ProductMapper getInstance(){
        if (INSTANCE == null){
            INSTANCE = new ProductMapper();
        }

        return INSTANCE;
    }

    public Product dtoToEntity(ProductRequestDTO dto){
        Product entity = new Product();
        entity.setId(dto.getId());
        entity.setName(dto.getName());
        entity.setImage(dto.getImage());
        entity.setActive(dto.getActive());
        entity.setCreatedDate(dto.getCreatedDate());
        entity.setUpdatedDate(dto.getUpdatedDate());
        return entity;
    }

    public ProductReponseDTO entityToDto(Product entity){
        ProductReponseDTO dto =  new ProductReponseDTO();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setActive(entity.getActive());
        dto.setImage(entity.getImage());
        dto.setCategory(entity.getCategory());
        dto.setCreatedDate(entity.getCreatedDate());
        dto.setUpdatedDate(entity.getUpdatedDate());
        return dto;
    }
}
