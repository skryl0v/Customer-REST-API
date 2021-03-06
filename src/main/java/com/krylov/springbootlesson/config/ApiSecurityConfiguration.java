package com.krylov.springbootlesson.config;

import com.krylov.springbootlesson.config.ApiBasicAuthenticationEntryPoint;
import com.krylov.springbootlesson.service.ApiUserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
@ComponentScan
public class ApiSecurityConfiguration extends WebSecurityConfigurerAdapter {
    @Autowired
    private ApiUserDetailService apiUserDetailService;
    @Autowired
    private ApiBasicAuthenticationEntryPoint apiAuthenticationEntryPoint;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .userDetailsService(apiUserDetailService)
                .passwordEncoder(passwordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .antMatcher("/api/v1/customers/**")
                .authorizeRequests()
                .anyRequest().authenticated()
                .and().httpBasic().authenticationEntryPoint(apiAuthenticationEntryPoint)
                .and().sessionManagement().disable();
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}