package com.rga.service.impl;

import com.rga.dao.UserDao;
import com.rga.model.User;
import com.rga.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by WinnieLin on 2015/10/22.
 */
@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public boolean addUser(User user) {
        userDao.insert(user);
        return true;
    }

    @Override
    public boolean updateUser(Integer id, User user) {
        user.setId(id);
        userDao.update(user);
        return false;
    }

    @Override
    public User find(Integer id) {
        return userDao.query(id);
    }

    @Override
    public User find(String email) {
        return userDao.query(email);
    }

    @Override
    public List<User> findAll() {
        return userDao.query();
    }
}
