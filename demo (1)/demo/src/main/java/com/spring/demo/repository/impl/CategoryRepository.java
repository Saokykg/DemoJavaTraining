package com.spring.demo.repository.impl;

import com.spring.demo.DAO.ICategoryDAO;
import com.spring.demo.DAO.impl.CategoryDAO;
import com.spring.demo.DAO.impl.ProductDAO;
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

    @Autowired
    private ICategoryDAO categoryDAO;

    @Override
    public List<Category> getFullList() {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        Query query = session.createQuery("From Category");
        return query.getResultList();
    }

    @Override
    public Category getById(int id) {
        return categoryDAO.get(id);
    }

    @Override
    public Category create(Category category) {
        categoryDAO.create(category);
        return category;
    }

    @Override
    public Category update(Category category) {
        System.out.println(category);
        if (this.categoryDAO.update(category)){
            categoryDAO.update(category);
            return category;
        }
        return null;
    }

    @Override
    public boolean delete(int id) {
        try {
            return categoryDAO.delete(id);
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return false;
    }

    @Override
    public List<Product> getProduct(int id) {
        Category category = categoryDAO.get(id);
        return category.getProducts();
    }

    @Override
    public Product addProduct(Product product) {
        ProductDAO productDAO = new ProductDAO();
        productDAO.create(product);
        return product;
    }

}
