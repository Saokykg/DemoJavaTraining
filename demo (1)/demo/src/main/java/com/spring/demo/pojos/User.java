package com.spring.demo.pojos;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Table(name = "user")
@Getter
@Setter

public class User {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NonNull
    @Size(min = 6, max = 12)
    private String username;

    @NonNull
    @Size(min = 6, max = 12)
    private String password;

    @Column(name = "refresh_token")
    private String refreshToken;

    @Transient
    @JsonIgnore
    private String token;
}
