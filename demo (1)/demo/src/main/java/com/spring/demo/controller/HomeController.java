package com.spring.demo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public ResponseEntity<String> index() {
        return new ResponseEntity<String>("Hello2", HttpStatus.OK);
    }
}
