package com.rga.utilty;

import org.json.simple.JSONValue;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author Green
 * @since 2015/10/04
 */
public class JSONUtils {

    public static String makeJsonText(Object data) {
        Map obj = new LinkedHashMap();
        obj.put("status", "ok");
        obj.put("version", "1");
        obj.put("data", data);
        return JSONValue.toJSONString(obj);
    }

    public static String makeJsonText(Object data, String message) {
        Map obj = new LinkedHashMap();
        obj.put("status", "ok");
        obj.put("version", "1");
        obj.put("data", data);
        obj.put("message", message);
        return JSONValue.toJSONString(obj);
    }
}
