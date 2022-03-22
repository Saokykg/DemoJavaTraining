package com.spring.demo.repository.impl;

import com.spring.demo.pojos.Category;
import com.spring.demo.repository.ICategoryRepository;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Query;
import java.util.List;

@Repository
@Transactional
public class CategoryRepository implements ICategoryRepository {

    @Autowired
    private LocalSessionFactoryBean sessionFactory;

    @Override
    public List<Category> getFullList() {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        Query query = session.createQuery("From Category");
        System.out.println(query.getResultList());
        return query.getResultList();
    }

    @Override
    public Category getById() {
        return null;
    }
}
