package com.spring.demo.repository.impl;

import com.spring.demo.model.User;

import java.util.List;

public interface IUserRepository {
    public List<User> getUsers();
    public User getUserById(int id);
    public User getUserByUsername(String username);
    public boolean addUser(User user);
    public boolean removeUserById(int id);
}
