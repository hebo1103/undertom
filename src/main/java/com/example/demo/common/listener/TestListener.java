package com.example.demo.common.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * @author HB
 * @data 2020/10/23 15:39
 * @Description: 控制层
 */
@WebListener
public class TestListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("==============Tomcat启动了！==============");
        System.out.println("==============Tomcat启动了！==============");
        System.out.println("==============Tomcat启动了！==============");
    }
    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("==============Tomcat销毁了！==============");
        System.out.println("==============Tomcat销毁了！==============");
    }

}
