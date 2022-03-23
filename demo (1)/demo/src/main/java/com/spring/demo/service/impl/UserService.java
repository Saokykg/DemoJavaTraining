package com.spring.demo.service.impl;

import com.spring.demo.pojos.User;
import com.spring.demo.repository.IUserRepository;
import com.spring.demo.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Transactional
@Service
public class UserService implements IUserService {
    @Autowired
    private IUserRepository userRepository;
    @Override
    public User getUserByUsername(String username) {
        return this.userRepository.getUserByUsername(username);
    }
}
