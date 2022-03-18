package com.spring.demo.service.impl;

import com.spring.demo.model.User;
import com.spring.demo.repository.IUserRepository;
import com.spring.demo.repository.impl.UserRepository;
import com.spring.demo.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserService implements IUserService {

    @Autowired
    private IUserRepository userRepository;

    @Override
    public List<User> getUsers() {
        return this.userRepository.getUsers();
    }

    @Override
    public User getUserById(int id) {
        return this.userRepository.getUserById(id);
    }

    @Override
    public User getUserByUsername(String username) {
        return this.userRepository.getUserByUsername(username);
    }

    @Override
    public boolean addUser(User user) {
        return false;
    }

    @Override
    public boolean removeUserById(int id) {
        return false;
    }

    @Override
    public Boolean setAccess_Token(User user) {
        return this.userRepository.setAccess_Token(user);
    }

    @Override
    public Boolean vertify(int id, String token) {
        return this.userRepository.vertify(id, token);
    }

    @Override
    public Boolean register(User user) {
        return this.userRepository.register(user);
    }
}
