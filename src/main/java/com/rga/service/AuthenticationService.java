package com.rga.service;

/**
 * @author Green
 * @since 2015/10/04
 */
public interface AuthenticationService {
    boolean authenticate(String userName, String password);
    boolean login(String userName);
    boolean logout(String userName);
    void saveUserId(String email);
    String getUserId();
}
