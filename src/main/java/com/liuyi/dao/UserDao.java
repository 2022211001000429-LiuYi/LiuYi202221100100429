package com.liuyi.dao;

import com.liuyi.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UserDao implements IUserDao{
    @Override
    public boolean saveUser(Connection con, User user) throws SQLException {
        //insert
        String sql="insert into usertable(username,password,email,gender,userbirth) values(?,?,?,?,?)" ;
        PreparedStatement ps=con.prepareStatement(sql);
        ps.setString(1,user.getUsername());
        ps.setString(2,user.getPassword());
        ps.setString(3,user.getEmail());
        ps.setString(4,user.getGender());
        ps.setDate(5, (java.sql.Date) user.getUserbirth());
        int row=ps.executeUpdate();
        if(row>0){
            return true;
        }
        return false;
    }

    @Override
    public int deleteUser(Connection con, User user) throws SQLException {
        //delete
        return 0;
    }

    @Override
    public int updateUser(Connection con, User user) throws SQLException {
        //update
        return 0;
    }

    @Override
    public User findById(Connection con, Integer id) throws SQLException {
        //select id=?
        String sql = "Select * from usertable where id=? ";
        PreparedStatement st=con.prepareStatement(sql);
        ResultSet rs=st.executeQuery();
        User user=null;
        if(rs.next()){//true
            user=new User();
            user.setId(rs.getInt("id"));
            user.setUsername(rs.getString("username"));
            user.setPassword(rs.getString("password"));
            user.setEmail(rs.getString("email"));
            user.setGender(rs.getString("gender"));
            user.setUserbirth(rs.getDate("userbirth"));
        }
        return user;
    }

    @Override
    public User findByUsernamePassword(Connection con, String username, String password) throws SQLException {
        //select password=? and username=?
        String sql = "Select * from usertable where username=? and password=?";
        PreparedStatement st=con.prepareStatement(sql);
        st.setString(1,username);
        st.setString(2,password);
        ResultSet rs=st.executeQuery();
        User user=null;
        if(rs.next()){//true
            user=new User();
            user.setId(rs.getInt("id"));
            user.setUsername(rs.getString("username"));
            user.setPassword(rs.getString("password"));
            user.setEmail(rs.getString("email"));
            user.setGender(rs.getString("gender"));
            user.setUserbirth(rs.getDate("userbirth"));
        }
        return user;
    }

    @Override
    public List<User> findByUsername(Connection con, String username) throws SQLException {
        //select Username=?
        String sql = "Select * from usertable where username=?";
        PreparedStatement st=con.prepareStatement(sql);
        st.setString(1,username);
        ResultSet rs=st.executeQuery();
        List<User> list = new ArrayList<>();
        User user1=null;
        while (rs.next()){//true
            user1=new User();
            user1.setId(rs.getInt("id"));
            user1.setUsername(rs.getString("username"));
            user1.setPassword(rs.getString("password"));
            user1.setEmail(rs.getString("email"));
            user1.setGender(rs.getString("gender"));
            user1.setUserbirth(rs.getDate("userbirth"));
            list.add(user1);
        }
        return list;
    }

    @Override
    public List<User> findByPassword(Connection con, String password) throws SQLException {
        //select password=?
        String sql = "Select * from usertable where password=?";
        PreparedStatement st=con.prepareStatement(sql);
        st.setString(1,password);
        ResultSet rs=st.executeQuery();
        List<User> list = new ArrayList<>();
        User user2=null;
        while (rs.next()){//true
            user2=new User();
            user2.setId(rs.getInt("id"));
            user2.setUsername(rs.getString("username"));
            user2.setPassword(rs.getString("password"));
            user2.setEmail(rs.getString("email"));
            user2.setGender(rs.getString("gender"));
            user2.setUserbirth(rs.getDate("userbirth"));
            list.add(user2);
        }
        return list;
    }

    @Override
    public List<User> findByEmail(Connection con, String email) throws SQLException {
        //select email=?
        String sql = "Select * from usertable where email=?";
        PreparedStatement st=con.prepareStatement(sql);
        st.setString(1,email);
        ResultSet rs=st.executeQuery();
        List<User> list = new ArrayList<>();
        User user3=null;
        while (rs.next()){//true
            user3=new User();
            user3.setId(rs.getInt("id"));
            user3.setUsername(rs.getString("username"));
            user3.setPassword(rs.getString("password"));
            user3.setEmail(rs.getString("email"));
            user3.setGender(rs.getString("gender"));
            user3.setUserbirth(rs.getDate("userbirth"));
            list.add(user3);
        }
        return list;
    }

    @Override
    public List<User> findByGender(Connection con, String gender) throws SQLException {
        //select gender=?
        String sql = "Select * from usertable where gender=?";
        PreparedStatement st=con.prepareStatement(sql);
        st.setString(1,gender);
        ResultSet rs=st.executeQuery();
        List<User> list = new ArrayList<>();
        User user4=null;
        while (rs.next()){//true
            user4=new User();
            user4.setId(rs.getInt("id"));
            user4.setUsername(rs.getString("username"));
            user4.setPassword(rs.getString("password"));
            user4.setEmail(rs.getString("email"));
            user4.setGender(rs.getString("gender"));
            user4.setUserbirth(rs.getDate("userbirth"));
            list.add(user4);
        }
        return list;
    }

    @Override
    public List<User> findByBirthdate(Connection con, Date birthDate) throws SQLException {

        String sql = "Select * from usertable where userbirth=?";
        PreparedStatement st=con.prepareStatement(sql);
        st.setDate(1, (java.sql.Date) birthDate);
        ResultSet rs=st.executeQuery();
        List<User> list = new ArrayList<>();
        User user5=null;
        while (rs.next()){//true
            user5=new User();
            user5.setId(rs.getInt("id"));
            user5.setUsername(rs.getString("username"));
            user5.setPassword(rs.getString("password"));
            user5.setEmail(rs.getString("email"));
            user5.setGender(rs.getString("gender"));
            user5.setUserbirth(rs.getDate("userbirth"));
            list.add(user5);
        }
        return list;
    }

    @Override
    public List<User> findAllUser(Connection con) throws SQLException {
        String sql = "Select * from usertable ";
        PreparedStatement st=con.prepareStatement(sql);
        ResultSet rs=st.executeQuery();
        List<User> list = new ArrayList<>();
        User user6=null;
        while (rs.next()){//true
            user6=new User();
            user6.setId(rs.getInt("id"));
            user6.setUsername(rs.getString("username"));
            user6.setPassword(rs.getString("password"));
            user6.setEmail(rs.getString("email"));
            user6.setGender(rs.getString("gender"));
            user6.setUserbirth(rs.getDate("userbirth"));
            list.add(user6);
        }
        return list;
    }
}
