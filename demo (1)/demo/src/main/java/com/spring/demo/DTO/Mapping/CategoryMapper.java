package com.spring.demo.DTO.Mapping;

import com.spring.demo.DTO.Request.CategoryRequestDTO;
import com.spring.demo.DTO.Response.CategoryReponseDTO;
import com.spring.demo.pojos.Category;

public class CategoryMapper {
    private static CategoryMapper INSTANCE;

    public static CategoryMapper getInstance(){
        if (INSTANCE == null){
            INSTANCE = new CategoryMapper();
        }

        return INSTANCE;
    }

    public Category dtoToEntity(CategoryRequestDTO dto){
        Category entity = new Category();
        entity.setName(dto.getName());
        entity.setDescription(dto.getDescription());
        return entity;
    }

    public CategoryReponseDTO entityToDto(Category entity){
        CategoryReponseDTO dto =  new CategoryReponseDTO();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setDescription(entity.getDescription());
        return dto;
    }
}
