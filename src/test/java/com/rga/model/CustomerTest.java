package com.rga.model;

import org.json.simple.JSONValue;
import org.junit.Test;

import java.util.LinkedHashMap;
import java.util.Map;

import static org.junit.Assert.*;

/**
 * @author Green
 * @since 2015/10/04
 */
public class CustomerTest {

    @Test
    public void testToJSONString() throws Exception {
        Customer customer = new Customer();
        customer.setId(1);
        customer.setAddress("9349 Fern Way Otumoetai Tauranga 829, New Zealand");
        customer.setFirstname("Jones");
        customer.setLastname("Charlie J.");
        customer.setPhone("(134) 7630-935");
        customer.setEmail("CharlieJJones@rewardupgrade.co.nz");

        Map obj = new LinkedHashMap();
        obj.put("id", 1);
        obj.put("firstname", customer.getFirstname());
        obj.put("lastname", customer.getLastname());
        obj.put("address", customer.getAddress());
        obj.put("email", customer.getEmail());
        obj.put("phone", customer.getPhone());
        String expected = JSONValue.toJSONString(obj);

        assertEquals(expected, customer.toJSONString());
    }
}