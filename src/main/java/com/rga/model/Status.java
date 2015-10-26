package com.rga.model;

import org.json.simple.JSONAware;
import org.json.simple.JSONValue;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by WinnieLin on 2015/10/22.
 */
public class Status implements JSONAware {

    private Integer id;
    private String message;
    private Integer userId;
    private User user;
    private Date createDate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toJSONString() {
        Map obj = new LinkedHashMap();
        obj.put("id", id);
        obj.put("message", message);
        obj.put("userId", userId);
        obj.put("user", user);
        obj.put("createDate", SimpleDateFormat.getInstance().format(createDate));
        return JSONValue.toJSONString(obj);
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}
