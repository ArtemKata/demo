package com.kazragis.demo.dao;

import com.kazragis.demo.model.User;
import org.springframework.stereotype.Repository;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
@Repository
public class UserDaoImp implements UserDao{

    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public List<User> showUsers() {
        return entityManager.createQuery("from User", User.class).getResultList();
    }

    @Override
    public User show(long id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public void save(User user) {
        entityManager.persist(user);
    }

    @Override
    public void update(long id, User user) {
        User userToBeUpdated = show(id);

        userToBeUpdated.setFirstName(user.getFirstName());
        userToBeUpdated.setLastName(user.getLastName());
        userToBeUpdated.setAge(user.getAge());
        userToBeUpdated.setEmail(user.getEmail());

        entityManager.merge(userToBeUpdated);
    }

    public void delete(long id) {
        User user = show(id);
        if (null == user) {
            throw new NullPointerException("User not found");
        }
        entityManager.remove(show(id));
        entityManager.flush();
    }
    }

