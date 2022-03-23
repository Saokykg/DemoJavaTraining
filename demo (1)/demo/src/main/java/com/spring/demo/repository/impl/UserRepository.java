package com.spring.demo.repository.impl;

import com.spring.demo.pojos.User;
import com.spring.demo.repository.IUserRepository;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Query;

@Repository
@Transactional
public class UserRepository implements IUserRepository {

    @Autowired
    LocalSessionFactoryBean sessionFactory;

    @Override
    public User getUserByUsername(String username) {
        Session session = sessionFactory.getObject().getCurrentSession();
        Query query = session.createQuery("FROM User where username = :username").setParameter("username", username);
        return (User) query.getSingleResult();
    }
}
