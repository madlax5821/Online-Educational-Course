package com.xiaofei.service.impl;

import com.xiaofei.dto.JwtUser;
import com.xiaofei.entity.Role;
import com.xiaofei.entity.User;
import com.xiaofei.hibernateDao.RoleDao;
import com.xiaofei.hibernateDao.UserDao;
import com.xiaofei.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Author: xiaofei
 * Date: 2022-05-23, 14:49
 * Description:
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    @Qualifier ("hibernateUserDao")
    private UserDao userDao;
    @Autowired
    @Qualifier("hibernateRoleDao")
    private RoleDao roleDao;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userDao.getUserByUsername(username);
        if (user==null){
            throw new UsernameNotFoundException("user does not exist");
        }

        Long id = user.getId();
        String password = user.getPassword();

        Set<Role> roles = roleDao.getRolesByUserId(id);
        List<GrantedAuthority> authorities = new ArrayList<>();
        
        for (Role role:roles){
            authorities.add(new SimpleGrantedAuthority(role.getRoleName()));
        }
//        return new JwtUser.JwtUserBuilder()
//                .setUsername(username)
//                .setPassword(password)
//                .setId(id)
//                .setAuthorities(authorities)
//                .build();
        return new JwtUser(user,password,authorities);
    }
}
