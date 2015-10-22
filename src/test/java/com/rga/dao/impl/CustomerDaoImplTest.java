package com.rga.dao.impl;

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
public class CustomerDaoImplTest extends TestCase {

    @Autowired
    private CustomerDao customerDao;

    @Test
    public void testInsert() throws Exception {
        customerDao.clear();

        Customer customer = new Customer();
        customer.setId(1);
        boolean actual = customerDao.insert(customer);
        assertTrue(actual);
    }

    @Test
    public void testUpdate() throws Exception {
        Customer expected = customerDao.query(1);
        expected.setAddress("R Goa 8508 2424-001 SOUTOCICO, Portugal");
        expected.setEmail("DonaldAChambers@ironjet.com.pt");
        expected.setFirstname("Chambers");
        expected.setLastname("Donald A.");
        expected.setPhone("74 244 660 0843");
        int actual = customerDao.update(expected);
        assertTrue(actual == 1);

        Customer actualCustomer = customerDao.query(1);
        assertEquals(actualCustomer.getAddress(), expected.getAddress());
        assertEquals(actualCustomer.getEmail(), expected.getEmail());
        assertEquals(actualCustomer.getFirstname(), expected.getFirstname());
        assertEquals(actualCustomer.getLastname(), expected.getLastname());
        assertEquals(actualCustomer.getPhone(), expected.getPhone());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testUpdateCustomerIdIsNull() throws Exception {
        Customer expected = new Customer();
        expected.setId(null);
        expected.setAddress("R Goa 8508 2424-001 SOUTOCICO, Portugal");
        expected.setEmail("DonaldAChambers@ironjet.com.pt");
        expected.setFirstname("Chambers");
        expected.setLastname("Donald A.");
        expected.setPhone("74 244 660 0843");
        customerDao.update(expected);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testUpdateCustomerIsNull() throws Exception {
        customerDao.update(null);
    }

    @Test
    public void testDelete() throws Exception {
        Customer expected = new Customer();
        expected.setId(1);
        expected.setAddress("R Goa 8508 2424-001 SOUTOCICO, Portugal");
        expected.setEmail("DonaldAChambers@ironjet.com.pt");
        expected.setFirstname("Chambers");
        expected.setLastname("Donald A.");
        expected.setPhone("74 244 660 0843");
        int actual = customerDao.delete(expected);
        assertEquals(actual, 1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testDeleteCustomerIsNull() throws Exception {
        customerDao.delete(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testDeleteCustomerIdIsNull() throws Exception {
        Customer expected = new Customer();
        expected.setId(null);
        expected.setAddress("R Goa 8508 2424-001 SOUTOCICO, Portugal");
        expected.setEmail("DonaldAChambers@ironjet.com.pt");
        expected.setFirstname("Chambers");
        expected.setLastname("Donald A.");
        expected.setPhone("74 244 660 0843");
        customerDao.delete(expected);
    }

    @Test
    public void testQuery() throws Exception {

        Customer actual = customerDao.query(1);
        assertEquals(actual.getId(), new Integer("1"));
    }

    @Test
    public void testQueryALl() throws Exception {
        customerDao.clear();

        Customer customer = new Customer();
        customer.setId(1);
        customerDao.insert(customer);

        customer = new Customer();
        customer.setId(2);
        customerDao.insert(customer);

        assertEquals(2, customerDao.countAll());
    }
}