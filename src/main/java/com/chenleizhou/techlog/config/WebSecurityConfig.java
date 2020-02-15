package com.chenleizhou.techlog.config;

import com.chenleizhou.techlog.entity.User;
import com.chenleizhou.techlog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    UserService userService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        User admin = userService.findUserByName("lei");
        auth.inMemoryAuthentication().withUser(admin.getName()).password("{noop}"+admin.getPassword()).roles("ADMIN");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
//        http.authorizeRequests()
//                .anyRequest().authenticated()
//                .and()
//                .formLogin()
//                .and()
//                .logout().permitAll();

        http.authorizeRequests()
                .antMatchers("/dashboard").authenticated()
                .and()
                .formLogin()
                .and()
                .logout().permitAll();

        http.logout().logoutSuccessUrl("/");

        http.csrf().disable();

        http.rememberMe();
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/images/**", "/files/**", "/asserts/**", "/webjars/**", "/user/**", "/", "/index", "/articles/**", "/article/**");
    }
}
