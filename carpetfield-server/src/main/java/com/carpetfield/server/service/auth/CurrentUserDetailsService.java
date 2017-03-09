package com.carpetfield.server.service.auth;

import com.carpetfield.server.domain.auth.CurrentUser;
import com.carpetfield.server.domain.auth.User;
import com.carpetfield.server.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * Created by selcukb on 09.03.2017.
 */
@Service
public class CurrentUserDetailsService implements UserDetailsService
{
    private final UserService userService;

    @Autowired
    public CurrentUserDetailsService(UserService userService) {
        this.userService = userService;
    }

    @Override
    public CurrentUser loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userService.getUserByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException(String.format("User with email '%s' was not found", email)));
        return new CurrentUser(user);
    }}
