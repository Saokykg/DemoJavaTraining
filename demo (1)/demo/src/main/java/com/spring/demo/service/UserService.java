package com.spring.demo.service;

import com.spring.demo.model.User;
import com.spring.demo.reponsitory.UserReponsitory;
import com.spring.demo.service.impl.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserService implements IUserService {


    @Autowired
    private UserReponsitory userRepository;

    @Override
    public List<User> getUsers() {
        return this.userRepository.getUsers();
    }

    @Override
    public User getUserById(int id) {
        return null;
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
}
