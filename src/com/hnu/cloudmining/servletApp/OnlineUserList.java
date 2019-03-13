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
    private static Set<String>  online_users = null;
    private ServletContext app = null;
    @Override
    public void attributeAdded(HttpSessionBindingEvent httpSessionBindingEvent) { // 一旦session添加属性，就触发该方法
        String name = httpSessionBindingEvent.getName();
        String value = (String) httpSessionBindingEvent.getValue();
        System.out.println("============= attributeAdded ================"+name + " : "+value);
        if("name".equals(name)){
            online_users.add(value);
            this.app.setAttribute("online_users",online_users);
        }
    }

    @Override
    public void attributeRemoved(HttpSessionBindingEvent httpSessionBindingEvent) { // 一旦session删除属性，就触发该方法
        String name = httpSessionBindingEvent.getName();
        String value =(String) httpSessionBindingEvent.getValue();
        System.out.println("============= attributeRemoved ================"+name + " : "+value);
        if(value!=null && "name".equals(name)){
            this.online_users.remove(value);
            this.app.setAttribute("online_users", online_users);
        }
    }

    @Override
    public void attributeReplaced(HttpSessionBindingEvent httpSessionBindingEvent) { //一旦session同名属性被替换，就会调用此方法
        System.out.println("============= attributeReplaced ================");

    }

    @Override
    public void sessionCreated(HttpSessionEvent httpSessionEvent) {         // 一旦session被创建，就会触发方法
        String name =(String) httpSessionEvent.getSession().getAttribute("name");
        System.out.println("=================== sessionCreated ============== "+ name);
        if(name !=null){
            this.online_users.add(name);
            this.app.setAttribute("online_users",online_users);
        }

    }

    @Override
    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {  // 一旦session被销毁，就会触发该方法
        String name = (String) httpSessionEvent.getSession().getAttribute("name");
        System.out.println("=================== sessionDestroyed ============== "+ name);
        if(name !=null){
            this.online_users.remove(name);
            this.app.setAttribute("online_users",online_users);
        }
    }

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {   // 一旦application对象被创建，就会调用该方法
        System.out.println("========================= contextInitialized  ==========================");
        online_users = new TreeSet<>();
        ServletContext application = servletContextEvent.getServletContext();
        this.app = application;
        this.app.setAttribute("online_users", online_users);
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) { // 一旦application对象被销毁，就会调用此方法
        System.out.println("========================= contextDestroyed  ==========================");

    }
}
