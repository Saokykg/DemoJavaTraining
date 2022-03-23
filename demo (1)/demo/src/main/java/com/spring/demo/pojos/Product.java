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
import java.util.Collection;
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

    @Size(min = 2, max = 255)
    @NotNull
    private String name;
    private String image;

    @CreationTimestamp
    @Column(name = "created_date")
    @NotNull
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date createdDate;

    @UpdateTimestamp
    @Column(name = "updated_date")// ko can thiet
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date updatedDate;

    private Boolean active = true;

    @JoinColumn(name = "category_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Category category;

    @Transient
    @NotNull
    private int cate_id;

//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "product")
//    private Collection<Comment> commentCollection;

//    @PrePersist
//    protected void onCreate(){
//        this.createdDate = new Date();
//    }
//
//    @PreUpdate
//    protected void onUpdate(){
//        this.updateddDate = new Date();
//    }
}
