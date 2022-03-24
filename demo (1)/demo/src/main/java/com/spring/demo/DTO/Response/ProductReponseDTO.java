package com.spring.demo.DTO.Response;

import com.spring.demo.pojos.Category;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
public class ProductReponseDTO {

    private Integer id;
    private String name;
    private String image;
    private Boolean active = true;
    private Category category;
    private Date createdDate;
    private Date updatedDate;

}
