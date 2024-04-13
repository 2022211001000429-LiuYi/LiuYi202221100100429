package com.liuyi.week5;
import com.liuyi.dao.UserDao;
import com.liuyi.model.User;
import com.liuyi.week3.emp;
import javax.servlet.*;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


//@WebServlet(
        //urlPatterns = {"/login"},loadOnStartup = 1
        //initParams = {
       //         @WebInitParam(name="driver",value="com.microsoft.sqlserver.jdbc.SQLServerDriver"),
         //       @WebInitParam(name="url",value="jdbc:sqlserver://localhost:1433;databaseName=userdb;integratedSecurity=false;encrypt=true;trustServerCertificate=true;"),
         //       @WebInitParam(name="username",value="sa"),
         //       @WebInitParam(name="password",value="123456789"),
        //}
//)
public class LoginServlet extends HttpServlet {
    Connection con = null;

    @Override
    public void init() throws ServletException {
        /*
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
         */

        con=(Connection) getServletContext().getAttribute("con");

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //doPost(request,response);
        request.getRequestDispatcher("WEB-INF/views/login.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        PrintWriter out=response.getWriter();
        String username = request.getParameter("username");
        String password = request.getParameter("password");
//write mvc code
        UserDao userDao=new UserDao();
        try {
            User user=userDao.findByUsernamePassword(con,username,password);//for login
            if(user!=null){//valid
                request.setAttribute("user",user);
                request.getRequestDispatcher("WEB-INF/views/userInfo.jsp").forward(request,response);
            }else {
                request.setAttribute("message","Username or Password Error!!!");
                request.getRequestDispatcher("WEB-INF/views/login.jsp").forward(request,response);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }






        /*
        String sql = "Select * from usertable where username=? and password=?";

        try{
            //ResultSet rs = con.createStatement().executeQuery(sql);
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setString(1,username1);
            ps.setString(2,password1);
            ResultSet rs =ps.executeQuery();
           // ps.close();

        if(rs.next()){//true
                //response.getWriter().println("Login Success!!!");
                //response.getWriter().println("Welcome:  "+username1);
            request.setAttribute("id",rs.getInt("id"));
            request.setAttribute("username",rs.getString("username"));
            request.setAttribute("password",rs.getString("password"));
            request.setAttribute("email",rs.getString("email"));
            request.setAttribute("gender",rs.getString("gender"));
            request.setAttribute("userbirth",rs.getString("userbirth"));
            request.getRequestDispatcher("userInfo.jsp").forward(request,response);

        }else {//false
                //response.getWriter().println("Username or Password Error!!!");
            request.setAttribute("message","Username or Password Error!!!");
            request.getRequestDispatcher("login.jsp").forward(request,response);
            }
    } catch(SQLException throwables) {
        throwables.printStackTrace();
    }

         */
    }
    }

