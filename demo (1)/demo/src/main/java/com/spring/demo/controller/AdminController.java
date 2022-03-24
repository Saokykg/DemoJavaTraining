package com.spring.demo.controller;

import com.spring.demo.pojos.User;
import com.spring.demo.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import io.jsonwebtoken.*;
import javax.validation.Valid;
import java.util.Date;

@Controller
@RequestMapping("/api/v1")
public class AdminController {

    @Autowired
    private IUserService userService;

    private final String JWT_SECRET = "123456";
    private final long JWT_EXPIRATION = 604800000L;

    @PostMapping("/login")
    public ResponseEntity<?> login(@Valid @RequestBody User user){
        User dbUser = this.userService.getUserByUsername(user.getUsername());
        if (dbUser != null){
            if (dbUser.getPassword().equals(user.getPassword())){
                Date now = new Date();
                Date expiryDate = new Date(now.getTime() + JWT_EXPIRATION);
                user.setToken(Jwts.builder().setSubject(user.getUsername()).setIssuedAt(now)
                        .setExpiration(expiryDate)
                        .signWith(SignatureAlgorithm.HS512, JWT_SECRET)
                        .compact());
                return new ResponseEntity<String>(user.getToken(), HttpStatus.ACCEPTED);
            }
        }
        return new ResponseEntity<String>("Wrong Username or Password", HttpStatus.UNAUTHORIZED);
    }

}
