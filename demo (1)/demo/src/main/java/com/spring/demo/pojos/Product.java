package com.spring.demo.pojos;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "product")
@Getter
@Setter
@ToString
public class Product implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
    private String image;

    @CreationTimestamp
    @Temporal(javax.persistence.TemporalType.DATE)
    @Column(name = "created_date")
    private Date createdDate;

    @UpdateTimestamp
    @Column(name = "updated_date")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date updatedDate;

    private Boolean active = true;

    @JoinColumn(referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Category category;

    public Product(){
        setActive(true);
    }
}
