package com.rga.model;

import org.json.simple.JSONAware;
import org.json.simple.JSONValue;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by WinnieLin on 2015/10/22.
 */
public class Status implements JSONAware {
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

    private Integer id;
    private String message;
    private Integer userId;

    @Override
    public String toJSONString() {
        Map obj = new LinkedHashMap();
        obj.put("id", id);
        obj.put("message", message);
        obj.put("userId", userId);
        return JSONValue.toJSONString(obj);
    }
}
