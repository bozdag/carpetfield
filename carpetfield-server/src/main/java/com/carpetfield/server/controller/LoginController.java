package com.carpetfield.server.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

/**
 * Created by selcukb on 09.03.2017.
 */
@Controller
public class LoginController
{
    @RequestMapping(value = "/login", method = GET)
    public ModelAndView getLoginPage(@RequestParam Optional<String> error)
    {
        return new ModelAndView("login", "error", error);
    }
}
