package com.spring.demo.repository;

import com.spring.demo.model.User;

import java.util.List;

public interface IUserRepository {
    public List<User> getUsers();
    public User getUserById(int id);
    public User getUserByUsername(String username);
    public boolean addUser(User user);
    public boolean removeUserById(int id);
    public Boolean setAccess_Token(User user);
    public Boolean vertify(int id, String token);
    public Boolean register(User user);
}
