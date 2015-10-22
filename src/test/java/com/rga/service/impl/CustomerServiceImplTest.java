package com.rga.service.impl;

import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author Green
 * @since 2015/10/04
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/applicationContext.xml" })
public class CustomerServiceImplTest extends TestCase {

    @Autowired
    private CustomerService customerService;

    @Test
    public void testAddCustomer() throws Exception {

        Customer customer = new Customer();
        customer.setId(1);
        customer.setAddress("Taipei Taiwan");
        customer.setEmail("john@gmail.com");
        customer.setFirstname("Cannon");
        customer.setLastname("John");
        customer.setPhone("028825252");

        boolean actual = customerService.addCustomer(customer);
        assertTrue(actual);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddCustomerIsNull() throws Exception {

        Customer customer = null;
        customerService.addCustomer(customer);
    }

    @Test
    public void testAddCustomerIdIsNull() throws Exception {

        Customer customer = new Customer();
        customer.setAddress("Taipei Taiwan");
        customer.setEmail("john@gmail.com");
        customer.setFirstname("Cannon");
        customer.setLastname("John");
        customer.setPhone("028825252");

        boolean actual = customerService.addCustomer(customer);
        assertTrue(actual);
    }

    @Test
    public void testRemoveCustomer() throws Exception {
        Customer customer = new Customer();
        customer.setId(3);
        customer.setAddress("Taipei Taiwan");
        customer.setEmail("john@gmail.com");
        customer.setFirstname("Cannon");
        customer.setLastname("John");
        customer.setPhone("028825252");

        boolean actual = customerService.addCustomer(customer);
        assertTrue(actual);

        actual = customerService.removeCustomer(3);
        assertTrue(actual);
    }

    @Test
    public void testRemoveNotExistedCustomer() throws Exception {
        Customer customer = new Customer();
        customer.setId(3);
        customer.setAddress("Taipei Taiwan");
        customer.setEmail("john@gmail.com");
        customer.setFirstname("Cannon");
        customer.setLastname("John");
        customer.setPhone("028825252");

        boolean actual = customerService.addCustomer(customer);
        assertTrue(actual);

        actual = customerService.removeCustomer(3);
        assertTrue(actual);

        actual = customerService.removeCustomer(3);
        assertFalse(actual);
    }

    @Test
    public void testUpdateCustomer() throws Exception {
        Customer customer = new Customer();
        customer.setId(4);
        customer.setAddress("Taipei Taiwan");
        customer.setEmail("john@gmail.com");
        customer.setFirstname("Cannon");
        customer.setLastname("John");
        customer.setPhone("028825252");

        boolean actual = customerService.addCustomer(customer);
        assertTrue(actual);

        customer.setAddress("Taipei Taiwan New");
        customer.setEmail("john@gmail.com New");
        customer.setFirstname("Cannon New");
        customer.setLastname("John New");
        customer.setPhone("028825252 New");
        actual = customerService.updateCustomer(4, customer);
        assertTrue(actual);

        Customer actualCustomer = customerService.findCustomer(4);
        assertEquals(customer.getAddress(), actualCustomer.getAddress());
        assertEquals(customer.getEmail(), actualCustomer.getEmail());
        assertEquals(customer.getFirstname(), actualCustomer.getFirstname());
        assertEquals(customer.getLastname(), actualCustomer.getLastname());
        assertEquals(customer.getPhone(), actualCustomer.getPhone());
    }

    @Test
    public void testFindCustomer() throws Exception {
        Customer customer = new Customer();
        customer.setId(1);
        customer.setAddress("Taipei Taiwan");
        customer.setEmail("john@gmail.com");
        customer.setFirstname("Cannon");
        customer.setLastname("John");
        customer.setPhone("028825252");

        boolean actual = customerService.addCustomer(customer);
        assertTrue(actual);

        Customer actualCustomer = customerService.findCustomer(1);
        assertEquals(customer.getId(), actualCustomer.getId());
        assertEquals(customer.getFirstname(), actualCustomer.getFirstname());
        assertEquals(customer.getAddress(), actualCustomer.getAddress());
        assertEquals(customer.getEmail(), actualCustomer.getEmail());
        assertEquals(customer.getLastname(), actualCustomer.getLastname());
        assertEquals(customer.getPhone(), actualCustomer.getPhone());
    }
}