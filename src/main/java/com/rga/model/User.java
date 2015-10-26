package com.rga.model;

import org.json.simple.JSONAware;
import org.json.simple.JSONValue;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author Green
 * @since 2015/10/04
 */
public class User implements JSONAware {

    private Integer id;

    private String name;

    private String password;

    private String email;

    private boolean isLogin;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isLogin() {
        return isLogin;
    }

    public void setIsLogin(boolean isLogin) {
        this.isLogin = isLogin;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toJSONString() {
        Map obj = new LinkedHashMap();
        obj.put("id", id);
        obj.put("name", name);
        obj.put("email", email);
        obj.put("password", password);
        return JSONValue.toJSONString(obj);
    }
}
