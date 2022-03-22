package com.spring.demo.pojos;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
@Table(name = "product")
@Getter
@Setter
@ToString
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Size(min = 2, max = 255)
    @NotNull
    private String name;
    private String image;

    @Column(name = "created_date")
    private Date createdDate;

    @Column(name = "updated_date")
    private Date updateddDate;

    private Boolean active = true;

    @JoinColumn(name = "category_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Category category;

    @PrePersist
    protected void onCreate(){
        this.createdDate = new Date();
    }

    @PreUpdate
    protected void onUpdate(){
        this.updateddDate = new Date();
    }
}
