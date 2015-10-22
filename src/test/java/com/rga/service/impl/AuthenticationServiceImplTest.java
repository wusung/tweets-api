package com.rga.service.impl;

import com.rga.dao.UserDao;
import com.rga.model.User;
import com.rga.service.AuthenticationService;
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
public class AuthenticationServiceImplTest extends TestCase {

    @Autowired
    private AuthenticationService authenticationService;

    @Autowired
    private UserDao userDao;

    @Test
    public void testAuthenticateLoginUser() throws Exception {
        User user = new User();
        user.setEmail("endy@gmail.com");
        user.setIsLogin(false);
        user.setName("Endy Cloudy");
        userDao.insert(user);
        boolean actual = authenticationService.authenticate(user.getEmail(), "");
        assertFalse(actual);
    }

    @Test
    public void testAuthenticateNotLoginUser() throws Exception {
        User user = new User();
        user.setEmail("Charlie J. Jones");
        user.setIsLogin(false);
        userDao.insert(user);
        boolean actual = authenticationService.authenticate(user.getEmail(), "");
        assertFalse(actual);
    }

    @Test
    public void testAuthenticateNotExistedUser() throws Exception {
        boolean actual;
        actual = authenticationService.authenticate("BonnieFAllen@petroleumbiz.no", "");
        assertFalse(actual);


    }

    @Test(expected = IllegalArgumentException.class)
    public void testAuthenticateUsernameIsNull() throws Exception {
        boolean actual;
        actual = authenticationService.authenticate(null, null);
        assertFalse(actual);
    }

    @Test
    public void testLogin() throws Exception {
        boolean actual;

        User user = new User();
        user.setEmail("ShadinHusamTouma@bingocounter.com");
        user.setIsLogin(true);
        user.setName("Shadin Husam Touma");
        userDao.insert(user);
        actual = authenticationService.login(user.getEmail());
        assertTrue(actual);

        user = new User();
        user.setEmail("MikeEPerea@mobilecircus.co.nz");
        user.setIsLogin(false);
        user.setName("Shadin Husam Touma");
        userDao.insert(user);
        actual = authenticationService.login(user.getEmail());
        assertTrue(actual);

        actual = authenticationService.login("VivianAGarcia@baseringtones.com.pt");
        assertFalse(actual);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testLoginUserIsNull() throws Exception {
        boolean actual;
        actual = authenticationService.login(null);
        assertFalse(actual);
    }

    @Test
    public void testLogout() throws Exception {
        boolean actual;
        User user = new User();
        user.setEmail("CeciliaACothran@dnsspecialist.it");
        user.setIsLogin(true);
        user.setName("Cecilia A. Cothran");
        userDao.insert(user);
        actual = authenticationService.logout(user.getEmail());
        assertTrue(actual);
    }

    @Test
    public void testLogoutNotLoginUser() throws Exception {
        boolean actual;

        User user = new User();
        user.setEmail("Patrick C. Garcia");
        user.setIsLogin(false);
        user.setName("PatrickCGarcia@cultureapps.pl");
        userDao.insert(user);
        actual = authenticationService.logout(user.getEmail());
        assertTrue(actual);
    }

    @Test
    public void testLogoutNotExistedUser() throws Exception {
        boolean actual;
        actual = authenticationService.logout("FranciscoLMedina@tropicalticket.it");
        assertFalse(actual);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testLogoutNameIsNull() throws Exception {
        boolean actual;
        actual = authenticationService.logout(null);
        assertFalse(actual);
    }
}