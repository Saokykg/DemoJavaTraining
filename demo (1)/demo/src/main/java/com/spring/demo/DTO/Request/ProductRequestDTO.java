package com.spring.demo.DTO.Request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import java.util.Date;

@Getter
@Setter
public class ProductRequestDTO {
    private int id;

    @Size(min = 2, max = 255)
    @NotNull
    private String name;
    private String image;

    private Boolean active;

//    @Positive
    private int category_id;
    private Date createdDate;
    private Date updatedDate;
}
