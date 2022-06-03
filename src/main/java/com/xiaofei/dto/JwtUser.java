package com.xiaofei.dto;

import com.xiaofei.entity.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Author: xiaofei
 * Date: 2022-05-23, 20:18
 * Description:
 */
public class JwtUser implements UserDetails {
    private Long id;
    private String username;
    private String password;
    private Collection<GrantedAuthority> authorities;

    public JwtUser() {
    }

    public JwtUser(JwtUserBuilder builder) {
        this.id= builder.id;
        this.username= builder.username;
        this.password= builder.password;
        this.authorities= builder.authorities;
    }

    public JwtUser(User user, String password, Collection<GrantedAuthority> authorities) {
        this.id = user.getId();
        this.username=user.getUsername();
        this.password=password;
        this.authorities=authorities;
    }

    public Long getId() {
        return id;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if (authorities==null){
            authorities=new ArrayList<>();
        }
        return authorities;
    }
    
    public static class JwtUserBuilder{
        private Long id;
        private String username;
        private String password;
        private Collection<GrantedAuthority> authorities;

        public JwtUserBuilder setId(Long id) {
            this.id = id;
            return this;
        }

        public JwtUserBuilder setUsername(String username) {
            this.username = username;
            return this;
        }

        public JwtUserBuilder setPassword(String password) {
            this.password = password;
            return this;
        }

        public JwtUserBuilder setAuthorities(Collection<GrantedAuthority> authorities) {
            this.authorities = authorities;
            return this;
        }
        
        public JwtUser build(){
            return new JwtUser(this);
        }
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
