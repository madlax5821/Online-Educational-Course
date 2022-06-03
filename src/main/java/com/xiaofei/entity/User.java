package com.xiaofei.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * Author: xiaofei
 * Date: 2022-05-23, 20:04
 * Description:
 */
public class User {
    private Long id;
    private String username;
    private String password;
    private Set<Role> roles;

    public Set<Role> getRoles() {
        if (roles==null){
            roles=new HashSet<>();
        }
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public void setUsername(String username){
        this.username=username;
    }

    public String getUsername() {
        return username;
    }
}
