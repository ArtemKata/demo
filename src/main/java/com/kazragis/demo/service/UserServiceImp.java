package com.kazragis.demo.service;

import com.kazragis.demo.dao.UserDao;
import com.kazragis.demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

@Service
public class UserServiceImp implements UserService {

    private final UserDao userDao;
    @Autowired
    public UserServiceImp(UserDao userDao) {
        this.userDao = userDao;
    }


    @Override
    public List<User> showUsers() {
        return userDao.showUsers();
    }

    @Override
    public User show(long id) {
        return userDao.show(id);
    }

    @Transactional
    @Override
    public void save(User user) {
        userDao.save(user);
    }

    @Transactional
    @Override
    public void update(long id, User user) {
        userDao.update(id, user);
    }

    @Transactional
    @Override
    public void delete(long id) {
        userDao.delete(id);
    }
}