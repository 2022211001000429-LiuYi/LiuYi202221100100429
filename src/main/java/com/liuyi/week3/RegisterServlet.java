package com.liuyi.week3;

import javax.servlet.*;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@WebServlet(
        urlPatterns = {"/register"},
        initParams = {
        @WebInitParam(name="driver",value="com.microsoft.sqlserver.jdbc.SQLServerDriver"),
        @WebInitParam(name="url",value="jdbc:sqlserver://localhost:1433;databaseName=userdb;integratedSecurity=false;encrypt=true;trustServerCertificate=true;"),
        @WebInitParam(name="username",value="sa"),
        @WebInitParam(name="password",value="123456789"),

}
)

public class RegisterServlet extends HttpServlet {
    Connection con=null;

    @Override
    public void init() throws ServletException {
        ServletConfig config=getServletConfig();
        String driver=config.getInitParameter("driver");//<param-name>driver</param-name>
        String url=config.getInitParameter("url");//<param-name>url</param-name>
        String username=config.getInitParameter("username");//<param-name>username</param-name>
        String password=config.getInitParameter("password");//<param-name>password</param-name>

        try {
            Class.forName(driver);
            con= DriverManager.getConnection(url,username,password);
            System.out.println("init()-->"+con);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        System.out.println("i am in init()");
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("i am in doGet()");

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("i am in doPost()");

        //no request.getParamter()// home work week 3

        //WEEK 3 - HOMEWORK
        String username=request.getParameter("username");
        String password=request.getParameter("password");
        String email=request.getParameter("email");
        String gender=request.getParameter("gender");
        String birthdate=request.getParameter("userbirth");
//WEEK 4 - HOMEWORK
        try{

            String sql="insert into usertable(username,password,email,gender,userbirth) values(?,?,?,?,?)" ;
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setString(1,username);
            ps.setString(2,password);
            ps.setString(3,email);
            ps.setString(4,gender);
            ps.setString(5,birthdate);

            int row=ps.executeUpdate();
            if(row>0){
                System.out.print("成功添加了"+row+"条数据！");
            }
            ps.close();

        }catch (Exception e){
            System.out.print("添加信息失败");
            e.printStackTrace();
        }


        String sql="select * from usertable";

        try {
            try (ResultSet rs = con.createStatement().executeQuery(sql)) {

              //WEEK 6- WE WILL DO LIKE THIS
                List<emp> list = new ArrayList<>();
                emp info=null;
                while (rs.next()) {
                 info=new emp();
                    info.setId (rs.getInt("id"));
                    info.setUsername(rs.getString("username"));
                    info.setEmail (rs.getString("email"));
                    info.setPassword(rs.getString("password"));
                    info.setGender(rs.getString("gender"));
                    info.setUserbirth(rs.getDate("userbirth"));
                    list.add(info);
                }
                request.setAttribute("list",list);
                rs.close();
            }
        }catch (SQLException throwables){
            throwables.printStackTrace();
        }
        //we will add THIS IN WEEK 6
        request.getRequestDispatcher("userlist.jsp").forward(request,response);
    }
}
