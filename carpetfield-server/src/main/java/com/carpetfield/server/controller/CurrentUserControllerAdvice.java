package com.carpetfield.server.controller;

import com.carpetfield.server.domain.auth.CurrentUser;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

/**
 * Created by selcukb on 09.03.2017.
 */
@ControllerAdvice
public class CurrentUserControllerAdvice
{
    @ModelAttribute("currentUser")
    public CurrentUser getCurrentUser(Authentication authentication)
    {
        return (authentication == null) ? null : (CurrentUser) authentication.getPrincipal();
    }
}
