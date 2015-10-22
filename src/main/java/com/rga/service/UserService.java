package com.rga.service;

import com.rga.model.User;

import java.util.List;

/**
 * Created by WinnieLin on 2015/10/22.
 */
public interface UserService {
    boolean addUser(User user);

    boolean updateUser(Integer id, User user);

    User find(Integer id);

    User find(String email);

    List<User> findAll();
}
