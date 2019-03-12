package com.hnu.cloudmining.servletApp;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by Administrator on 2019/3/12.
 */
public class OnlineUserList implements HttpSessionAttributeListener,HttpSessionListener,ServletContextListener {
    private static Set<String>  online_users = new TreeSet<>();
    private ServletContext app = null;
    @Override
    public void attributeAdded(HttpSessionBindingEvent httpSessionBindingEvent) {
        String name = httpSessionBindingEvent.getName();
        online_users.add(name);
        this.app.setAttribute("online_users",online_users);
    }

    @Override
    public void attributeRemoved(HttpSessionBindingEvent httpSessionBindingEvent) {
        String name = httpSessionBindingEvent.getName();
        String value =(String) httpSessionBindingEvent.getValue();
        if(value!=null){
            this.online_users.remove(value);
            this.app.setAttribute("online_users", online_users);
        }
    }

    @Override
    public void attributeReplaced(HttpSessionBindingEvent httpSessionBindingEvent) {

    }

    @Override
    public void sessionCreated(HttpSessionEvent httpSessionEvent) {
        String name =(String) httpSessionEvent.getSession().getAttribute("name");
        if(name !=null){
            this.online_users.add(name);
            this.app.setAttribute("online_users",online_users);
        }

    }

    @Override
    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {
        String name = (String) httpSessionEvent.getSession().getAttribute("name");
        if(name !=null){
            this.online_users.remove(name);
            this.app.setAttribute("online_users",online_users);
        }
    }

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        ServletContext application = servletContextEvent.getServletContext();
        this.app = application;
        this.app.setAttribute("online_users", online_users);
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
