package com.liuyi.week3;

import java.util.Date;

public class emp{
    public int id;
    public String username;
    public String password;
    public String email;
    public String gender;
    public Date userbirth;

    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id=id;
    }

    public String getUsername(){return  username;}
    public void setUsername(String username){this.username=username;}

    public String getEmail(){return  email;}
    public void setEmail(String email){this.email=email;}

    public String getPassword(){return  password;}
    public void setPassword(String password){this.password=password;}

    public String getGender(){return gender;}
    public void setGender(String gender){this.gender=gender;}

    public Date getUserbirth(){return  userbirth;}
    public void setUserbirth(Date userbirth){this.userbirth=userbirth;}

}

