package com.appdev.app.configuration;

import com.appdev.app.service.EcommUserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

public class SecurityConfig  extends WebSecurityConfigurerAdapter {
    @Autowired
    private EcommUserDetailService ecommUserDetailService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception{
        auth.userDetailsService(ecommUserDetailService);
    }

    //loginfo to swagger3
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()  // Disable CSRF if not needed
                .authorizeRequests()
                .antMatchers("/v3/api-docs/**", "/swagger-ui/**", "/swagger-ui/index.html/").permitAll()  // Allow access to Swagger UI
//                .anyRequest().authenticated();  // Secure all other endpoints
                .anyRequest().permitAll();  // permitall
    }
}
