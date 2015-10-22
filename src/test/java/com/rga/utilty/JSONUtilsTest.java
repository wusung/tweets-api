package com.rga.utilty;

import org.json.simple.JSONValue;
import org.junit.Test;

import java.util.LinkedHashMap;
import java.util.Map;

import static org.junit.Assert.*;

/**
 * @author Green
 * @since 2015/10/04
 */
public class JSONUtilsTest {

    @Test
    public void testMakeJsonText() throws Exception {
        String actual = JSONUtils.makeJsonText("Test data");

        Map expected = new LinkedHashMap();
        expected.put("status", "ok");
        expected.put("version", "1");
        expected.put("data", "Test data");
        assertEquals(JSONValue.toJSONString(expected), actual);
    }
}