package com.kazragis.demo.service;



import com.kazragis.demo.model.User;

import java.util.List;

public interface UserService {
    List<User> showUsers();
    User show(long id);
    void save(User user);
    void update(long id, User user);
    void delete(long id);
}
