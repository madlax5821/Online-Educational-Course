package com.xiaofei.config;

import com.sun.org.apache.xpath.internal.operations.And;
import com.xiaofei.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

/**
 * Author: xiaofei
 * Date: 2022-05-23, 16:11
 * Description:
 */
@Configuration
@EnableWebSecurity
public class WebServiceSecurityConfig extends WebSecurityConfigurerAdapter {
    
    @Autowired
    private UserService userService;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    protected UserDetailsService userDetailsService() {
        String encryptPass = passwordEncoder.encode("123");
        InMemoryUserDetailsManager inMemoryUserDetailsManager = new InMemoryUserDetailsManager();
        inMemoryUserDetailsManager.createUser(User.withUsername("xiaofeifei").password(encryptPass).roles("ADMIN").build());
        return inMemoryUserDetailsManager;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService()).passwordEncoder(passwordEncoder);
        //auth.userDetailsService(userService).passwordEncoder(passwordEncoder);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http    
                .csrf().disable().cors().disable()
                .headers().frameOptions().disable()
                .and()
                .authorizeRequests()
                .antMatchers("/","/500","/index","/alipay/**","/weixinpay/**","/myCenter",
                        "/toPayVip","/qqLogin","/userLogout","/weixinconnect/**","/main",
                        "/weixinLogin","/connect","/images/**","/loginDialog.html","/carouselImages/**",
                        "/courseImages/**","/teacherImages/**","/systemImages/**","/js/**","/layui/**","/ckeditor/**",
                        "/css/**","/courseImages/**","/articleImages/**","/course/**","/article/**","/wap/**","/error/**").permitAll() // no authentication required
                .antMatchers("/pages/**","/images/**").permitAll() //static resources
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login")
                .defaultSuccessUrl("/admin").permitAll()
                .and()
                .logout()
                .logoutSuccessUrl("/login").permitAll();
    }
}
