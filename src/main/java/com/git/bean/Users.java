package com.git.bean;
// Generated 2017-10-14 23:20:54 by Hibernate Tools 3.2.1.GA



/**
 * Users generated by hbm2java
 */
public class Users  implements java.io.Serializable {


     private Long id;
     private String username;
     private Long password;

    public Users() {
    }

    public Users(String username, Long password) {
       this.username = username;
       this.password = password;
    }
   
    public Long getId() {
        return this.id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    public String getUsername() {
        return this.username;
    }
    
    public void setUsername(String username) {
        this.username = username;
    }
    public Long getPassword() {
        return this.password;
    }
    
    public void setPassword(Long password) {
        this.password = password;
    }




}

