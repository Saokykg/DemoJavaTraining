package com.spring.demo.service;

import com.spring.demo.pojos.User;

public interface IUserService {
    User getUserByUsername(String username);
}
