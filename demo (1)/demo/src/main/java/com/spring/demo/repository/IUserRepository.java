package com.spring.demo.repository;

import com.spring.demo.pojos.User;

public interface IUserRepository {
    User getUserByUsername(String username);
}
