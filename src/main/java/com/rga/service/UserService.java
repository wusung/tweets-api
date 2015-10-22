package com.rga.service;

import com.rga.model.User;

/**
 * Created by WinnieLin on 2015/10/22.
 */
public interface UserService {
    boolean addUser(User user);

    boolean updateUser(Integer id, User user);

    User find(Integer id);

    User find(String email);
}
