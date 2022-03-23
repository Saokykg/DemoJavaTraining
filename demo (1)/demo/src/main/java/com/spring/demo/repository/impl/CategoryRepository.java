package com.spring.demo.repository.impl;

import com.spring.demo.pojos.Category;
import com.spring.demo.pojos.Product;
import com.spring.demo.repository.ICategoryRepository;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Query;
import java.util.Collection;
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
    public Category getById(int id) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        return session.get(Category.class, id);
    }

    @Override
    public Category create(Category category) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        session.save(category);
        return category;
    }

    @Override
    public Category update(Category category) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        session.update(category);
        return category;
    }

    @Override
    public boolean delete(int id) {
        try {
            Session session = this.sessionFactory.getObject().getCurrentSession();
            session.delete(session.get(Category.class, id));
            return true;
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return false;
    }

    @Override
    public List<Product> getProduct(int id) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        Category category = session.get(Category.class, id);
        return category.getProducts();
    }

    @Override
    public Product addProduct(Product product) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        session.save(product);
        return product;
    }

}
