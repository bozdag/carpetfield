package com.carpetfield.server.config;

import com.carpetfield.server.security.JWTAuthenticationFilter;
import com.carpetfield.server.security.JWTLoginFilter;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * Created by alicana on 28/03/2017.
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http.csrf().disable().authorizeRequests()
        // everyone can access root
        .antMatchers("/").permitAll()
        // login route is only publicly available for post requests
        .antMatchers(HttpMethod.POST, "/login").permitAll()
        // any other requests should be authenticated
        .anyRequest().authenticated()
        .and()
        // We filter the api/login requests
        .addFilterBefore(new JWTLoginFilter("/login", authenticationManager()),
            UsernamePasswordAuthenticationFilter.class)
        // And filter other requests to check the presence of JWT in header
        .addFilterBefore(new JWTAuthenticationFilter(),
            UsernamePasswordAuthenticationFilter.class);
  }

  @Override
  protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    // Create a default account
    auth.inMemoryAuthentication()
        .withUser("admin")
        .password("password")
        .roles("ADMIN");
  }
}
