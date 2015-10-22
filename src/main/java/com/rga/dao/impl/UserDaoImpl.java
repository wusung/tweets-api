package com.rga.dao.impl;

import com.rga.dao.UserDao;
import com.rga.model.User;
import org.springframework.stereotype.Service;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * @author Green
 * @since 2015/10/04
 */
@Service("userDao")
public class UserDaoImpl implements UserDao {

    private ConcurrentMap<Integer, User> users = new ConcurrentHashMap<>();

    @Override
    public boolean insert(User user) {
        if (user == null)
            throw new IllegalArgumentException("user is null");

        users.put(user.getId(), user);
        return true;
    }

    @Override
    public User query(Integer id) {
        if (users.containsKey(id)) {
            return users.get(id);
        }
        return null;
    }

    @Override
    public User query(String userName) {
        for (User u : users.values()) {
            if (u.getEmail().equals(userName))
                return u;
        }
        return null;
    }

    @Override
    public boolean update(User user) {
        if (user != null) {
            if (users.containsKey(user.getId())) {
                User existedUser = users.get(user.getId());
                existedUser.setIsLogin(user.isLogin());
                existedUser.setName(user.getName());
                existedUser.setEmail(user.getEmail());
                existedUser.setPassword(user.getPassword());
                return true;
            }
        }

        return false;
    }
}
