package com.liuyi.week6;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@WebListener
public class JDBCServletContextListener implements ServletContextListener {

    public JDBCServletContextListener(){}
    @Override
    public void contextInitialized(ServletContextEvent sce) {

        ServletContext Context=sce.getServletContext();
        String driver=Context.getInitParameter("driver");//<param-name>driver</param-name>
        String url=Context.getInitParameter("url");//<param-name>url</param-name>
        String username=Context.getInitParameter("username");//<param-name>username</param-name>
        String password=Context.getInitParameter("password");//<param-name>password</param-name>

        try {
            Class.forName(driver);
            Connection con= DriverManager.getConnection(url,username,password);
            System.out.println("i am in contextInitialized()-->"+con);
            //System.out.println("init()-->"+con);
            Context.setAttribute("con",con);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

        //System.out.println("i am in contextInitialized()");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("i am in contextDestroyed()");
        //sce.getServletContext().removeAttribute("con");
        ServletContext context=sce.getServletContext();
        Connection con=(Connection) context.getAttribute("con");

        try {
            con.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
        context.removeAttribute("con");
    }
}
