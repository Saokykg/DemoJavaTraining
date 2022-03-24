package com.spring.demo.DAO.impl;

import com.spring.demo.DAO.ICategoryDAO;
import com.spring.demo.pojos.Category;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Component
public class CategoryDAO implements ICategoryDAO {

    @Autowired
    private LocalSessionFactoryBean sessionFactory;

    @Override
    public Category get(int id) {
        Session session = sessionFactory.getObject().getCurrentSession();
        Category cate = session.get(Category.class, id);
        return cate;
    }

    @Override
    public boolean create(Category category) {
        Session session = sessionFactory.getObject().getCurrentSession();
        session.save(category);
        return true;
    }

    @Override
    public boolean update(Category category) {
        Session session = sessionFactory.getObject().getCurrentSession();
        session.update(category);
        return true;
    }

    @Override
    public boolean delete(int id) {
        Session session = sessionFactory.getObject().getCurrentSession();
        session.delete(session.get(Category.class, id));
        return true;
    }
}
