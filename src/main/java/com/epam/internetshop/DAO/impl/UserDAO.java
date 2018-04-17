package com.epam.internetshop.DAO.impl;

import com.epam.internetshop.DAO.DAO;
import com.epam.internetshop.domain.User;
import org.hibernate.*;
import com.epam.internetshop.DAO.util.HibernateSessionFactory;

import javax.persistence.criteria.*;
import javax.persistence.criteria.CriteriaQuery;

import java.util.List;

public class UserDAO implements DAO<User> {

    public List<User> getAll() {
        Session session = HibernateSessionFactory.getSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();

        session.beginTransaction();

        CriteriaQuery<User> criteria = builder.createQuery(User.class);
        criteria.from(User.class);

        List<User> list = session.createQuery(criteria).getResultList();

        session.getTransaction().commit();

        session.close();
        return list;
    }

    public User getById(Long id) {
        Session session = HibernateSessionFactory.getSession();
        User user = null;

        session.beginTransaction();
        user = session.get(User.class, id);
        session.getTransaction().commit();

        session.close();
        return user;
    }

    public User getByLogin(User user) {
        Session session = HibernateSessionFactory.getSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();

        session.beginTransaction();

        CriteriaQuery<User> query = builder.createQuery(User.class);
        Root<User> root = query.from(User.class);
        query.select(root).
                where(builder.equal(root.get("login"), user.getLogin()));
        user = (User) session.createQuery(query).getSingleResult();

        session.getTransaction().commit();

        session.close();
        return user;
    }

    public User getByLoginAndPassword(User user) {
        Session session = HibernateSessionFactory.getSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();

        session.beginTransaction();

        CriteriaQuery<User> query = builder.createQuery(User.class);
        Root<User> root = query.from(User.class);
        query.select(root).
                where(builder.equal(root.get("login"), user.getLogin()),
                        builder.equal(root.get("password"), user.getPassword()));
        user = (User) session.createQuery(query).getSingleResult();

        session.getTransaction().commit();

        session.close();
        return user;
    }

}