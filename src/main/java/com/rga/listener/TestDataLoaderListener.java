package com.rga.listener;

import com.rga.dao.UserDao;
import com.rga.model.User;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * @author Green
 * @since 2015/10/05
 */
public class TestDataLoaderListener implements ServletContextListener {

    private static final String DISPATCHER_SERVLET_CONTEXT_ATTR_NAME =
            "org.springframework.web.servlet.FrameworkServlet.CONTEXT.dispatcher";

    @Override
    public void contextInitialized(ServletContextEvent sce) {

        ServletContext stx = sce.getServletContext();

        WebApplicationContext rootContext = getRootWebApplicationContext(stx);

        UserDao userDao = rootContext.getBean(UserDao.class);
        {
            User user = new User();
            user.setId(1);
            user.setName("Wusung");
            user.setEmail("twkoci@gmail.com");
            user.setPassword("franky");
            userDao.insert(user);
        }

        {
            User user = new User();
            user.setId(2);
            user.setName("Franky");
            user.setEmail("franky@gmail.com");
            user.setPassword("1234");
            userDao.insert(user);
        }

    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }

    private WebApplicationContext getRootWebApplicationContext(ServletContext stx){
        return WebApplicationContextUtils.getWebApplicationContext( stx );
    }

    private WebApplicationContext getDispatcherServletWebApplicationContext(ServletContext stx){
        return WebApplicationContextUtils.getWebApplicationContext(stx,
                DISPATCHER_SERVLET_CONTEXT_ATTR_NAME);
    }
}
