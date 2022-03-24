package com.spring.demo.DAO.impl;

import com.spring.demo.DAO.ICategoryDAO;
import com.spring.demo.DAO.IProductDAO;
import com.spring.demo.pojos.Category;
import com.spring.demo.pojos.Product;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Component
public class ProductDAO implements IProductDAO {

    @Autowired
    private LocalSessionFactoryBean sessionFactory;

    @Override
    public Product get(int id) {
        Session session = sessionFactory.getObject().getCurrentSession();
        Product product = session.get(Product.class, id);
        return product;
    }

    @Override
    public boolean create(Product product) {
        Session session = sessionFactory.getObject().getCurrentSession();
        session.save(product);
        return true;
    }

    @Override
    public boolean update(Product product) {
        Session session = sessionFactory.getObject().getCurrentSession();
        session.update(product);
        return true;
    }

    @Override
    public boolean delete(int id) {
        Session session = sessionFactory.getObject().getCurrentSession();
        session.delete(session.get(Product.class, id));
        return true;
    }
}
