package com.spring.demo.repository.impl;

import com.spring.demo.DAO.IProductDAO;
import com.spring.demo.pojos.Product;
import com.spring.demo.repository.IProductRepository;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Query;
import java.util.List;

@Repository
@Transactional
public class ProductRepository implements IProductRepository {

    @Autowired
    LocalSessionFactoryBean sessionFactory;

    @Autowired
    IProductDAO productDAO;

    @Override
    public List<Product> getByCategory(int id) {
        Session session = sessionFactory.getObject().getCurrentSession();
        Query query = session.createQuery("FROM Product where category_id = :cate_id").setParameter("cate_id", id);
        return query.getResultList();
    }

    @Override
    public List<Product> getFullList() {
        Session session = sessionFactory.getObject().getCurrentSession();
        Query query = session.createQuery("FROM Product");
        return query.getResultList();
    }

    @Override
    public Product getById(int id) {
        return productDAO.get(id);
    }

    @Override
    public Product create(Product product) {
        if (productDAO.create(product))
            return product;
        else
            return null;
    }

    @Override
    public Product update(Product product) {
        System.out.println(product);
        productDAO.update(product);
        return product;
    }

    @Override
    public Boolean delete(int id) {
        try{
            return productDAO.delete(id);
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return false;
    }

    @Override
    public Boolean changeCate(int id) {
        return true;
    }
}
