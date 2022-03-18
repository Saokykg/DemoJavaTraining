package com.spring.demo.repository.impl;

import com.spring.demo.model.User;
import com.spring.demo.repository.IUserRepository;
import org.hibernate.DuplicateMappingException;
import org.hibernate.HibernateError;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.sql.SQLException;
import java.util.List;

@Repository
@Transactional
public class UserRepository implements IUserRepository {

    @Autowired
    private LocalSessionFactoryBean sessionFactory;

    @Override
    public List<User> getUsers() {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        Query query = session.createQuery("FROM User");
        System.out.println(query.toString());
        return query.getResultList();
    }

    @Override
    public User getUserById(int id) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        return session.get(User.class, id);
    }

    @Override
    public User getUserByUsername(String username) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        String hql = "FROM User U WHERE U.username = :username";
        Query query = session.createQuery(hql).setParameter("username", username);
        List results = query.getResultList();
        if (results.isEmpty())
            return null;
        else
            return (User) results.get(0);
//        CriteriaBuilder builder = session.getCriteriaBuilder();
//        CriteriaQuery<User> query = builder.createQuery(User.class);
//        Root root = query.from(User.class);
//        query.select(root);
//        if (!username.isEmpty()) {
//            Predicate p = builder.equal(root.get("username").as(String.class), username.trim());
//            query = query.where(p);
//        }
//
//        Query q = session.createQuery(query);
//        System.out.println(q.getSingleResult());
//        return (User) q.getSingleResult();
    }

    @Override
    public boolean addUser(User user) {
        return false;
    }

    @Override
    public boolean removeUserById(int id) {
        return false;
    }

    @Override
    public Boolean setAccess_Token(User user) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        session.merge(user);
        return true;
    }

    @Override
    public Boolean vertify(int id, String token) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        User user = session.get(User.class, id);
        return user.getAccess_token().equals(token);
    }

    @Override
    public Boolean register(User user) {
        try {
            Session session = this.sessionFactory.getObject().getCurrentSession();
            session.save(user);
            return true;
        } catch (Throwable ex) {
//            ex.printStackTrace();
        }
        return false;
    }
}
