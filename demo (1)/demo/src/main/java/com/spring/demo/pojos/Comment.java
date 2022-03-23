//package com.spring.demo.pojos;
//
//import javax.persistence.*;
//import javax.validation.constraints.NotNull;
//import javax.validation.constraints.Size;
//import java.util.Date;
//
//public class Comment {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "id")
//    private Integer id;
//
//    @NotNull
//    @Size(min = 1, max = 255)
//    @Column(name = "content")
//    private String content;
//
//    @JoinColumn(name = "product_id", referencedColumnName = "id")
//    @ManyToOne(optional = false)
//    private Product product;
//
////    @JoinColumn(name = "user_id", referencedColumnName = "id")
////    @ManyToOne(optional = false)
////    private User userId;
//
//    @Column(name = "created_date")
//    @Temporal(javax.persistence.TemporalType.DATE)
//    private Date createdDate;
//}
