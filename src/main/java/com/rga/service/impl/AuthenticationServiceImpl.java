package com.rga.service.impl;

import com.rga.dao.UserDao;
import com.rga.model.User;
import com.rga.service.AuthenticationService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Green
 * @since 2015/10/04
 */
@Service("authenticationService")
public class AuthenticationServiceImpl implements AuthenticationService {

    @Autowired
    private UserDao userDao;

    private String email;

    @Override
    public boolean authenticate(String userName, String password) {
        if (StringUtils.isEmpty(userName))
            throw new IllegalArgumentException("userName is null");

        User user = userDao.query(userName);
        if (user != null) {
            return password.equals(user.getPassword());
        }
        return false;
    }

    @Override
    public boolean login(String userName) {
        if (StringUtils.isEmpty(userName))
            throw new IllegalArgumentException("userName is null");

        User user = userDao.query(userName);
        if (user != null) {
            user.setIsLogin(true);
            userDao.update(user);
            return true;
        }
        return false;
    }

    @Override
    public boolean logout(String userName) {
        if (StringUtils.isEmpty(userName))
            throw new IllegalArgumentException("userName is null");

        User user = userDao.query(userName);
        if (user != null) {
            user.setIsLogin(false);
            userDao.update(user);
            return true;
        }
        return false;
    }

    @Override
    public void saveUserId(String email) {
        this.email = email;
    }

    @Override
    public String getUserId() {
        return this.email;
    }
}
