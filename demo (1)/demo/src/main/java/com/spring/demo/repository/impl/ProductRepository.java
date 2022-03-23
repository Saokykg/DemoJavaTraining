package com.spring.demo.repository.impl;

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
        Session session = sessionFactory.getObject().getCurrentSession();
        return session.get(Product.class, id);
    }

    @Override
    public Product create(Product product) {
        Session session = sessionFactory.getObject().getCurrentSession();
        session.save(product);
        return product;
    }

    @Override
    public Product update(Product product) {
        Session session = sessionFactory.getObject().getCurrentSession();
        System.out.println(product.getCategory());
        session.update(product);
        return product;
    }

    @Override
    public Boolean delete(int id) {
        try{
            Session session = sessionFactory.getObject().getCurrentSession();
            session.delete(session.get(Product.class, id));
            return true;
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
