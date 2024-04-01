package com.liuyi.week5;
import com.liuyi.week3.emp;
import javax.servlet.*;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


@WebServlet(
        urlPatterns = {"/login"},
        initParams = {
                @WebInitParam(name="driver",value="com.microsoft.sqlserver.jdbc.SQLServerDriver"),
                @WebInitParam(name="url",value="jdbc:sqlserver://localhost:1433;databaseName=userdb;integratedSecurity=false;encrypt=true;trustServerCertificate=true;"),
                @WebInitParam(name="username",value="sa"),
                @WebInitParam(name="password",value="123456789"),

        }
)
public class LoginServlet extends HttpServlet {
    Connection con = null;

    @Override
    public void init() throws ServletException {
        ServletConfig config = getServletConfig();
        String driver = config.getInitParameter("driver");//<param-name>driver</param-name>
        String url = config.getInitParameter("url");//<param-name>url</param-name>
        String username = config.getInitParameter("username");//<param-name>username</param-name>
        String password = config.getInitParameter("password");//<param-name>password</param-name>

        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url, username, password);
            System.out.println("init()-->" + con);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        System.out.println("i am in init()");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String username1 = request.getParameter("username");
        String password1 = request.getParameter("password");
        String sql = "Select * from usertable where username=? and password=?";

        try{
            //ResultSet rs = con.createStatement().executeQuery(sql);
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setString(1,username1);
            ps.setString(2,password1);
            ResultSet rs =ps.executeQuery();
           // ps.close();

        if(rs.next()){//true
                response.getWriter().println("Login Success!!!");
                response.getWriter().println("Welcome:  "+username1);
            }else {//false
                response.getWriter().println("Username or Password Error!!!");
            }
    } catch(SQLException throwables) {
        throwables.printStackTrace();
    }
        //request.getRequestDispatcher("loginlist.jsp").forward(request,response);
    }
    }

