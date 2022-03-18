package com.spring.demo.controller;

import com.spring.demo.model.User;
import com.spring.demo.service.IUserService;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.nio.charset.Charset;
import java.util.List;
import java.util.Random;

@Controller
public class UserController {

    @Autowired
    private IUserService userService;

    @GetMapping("/user")
    public ResponseEntity<List<User>> getAllUser(){
        List<User> users = this.userService.getUsers();
        return new ResponseEntity<List<User>>(users, HttpStatus.OK);
    }

    @PostMapping("/user")
    public ResponseEntity<User> createTutorial(@RequestBody User clientUser) {
        try {
            User user = this.userService.getUserByUsername(clientUser.getUsername());
            if (user != null) {
                if (user.getPassword().equals(clientUser.getPassword())) {
                    user.setAccess_token(String.format("%d;%s",user.getId(), "TOKEN"));
                    if (this.userService.setAccess_Token(user))
                        return new ResponseEntity<>(user, HttpStatus.OK);
                }
            }
            return new ResponseEntity<User>(HttpStatus.UNAUTHORIZED);
        }catch (Exception ex){
            ex.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }

    @GetMapping("/user/{id}")
    public ResponseEntity<User> getUserById(@RequestHeader(value = "authorization", defaultValue = "") String auth,
                                             @PathVariable(value = "id") int id){
        if (auth != "") {
            String tmp[] = auth.split(";");
            if (tmp.length==2)
            if (this.userService.vertify(Integer.parseInt(tmp[0]), auth)) {
                User user = (User) this.userService.getUserById(id);
                return new ResponseEntity<User>(user, HttpStatus.OK);
            }
        }
        return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
    }

    @PostMapping("/user/register")
    public ResponseEntity<User> register(@RequestBody User user){
        if (this.userService.register(user)){
            return new ResponseEntity<User>(user, HttpStatus.CREATED);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}
