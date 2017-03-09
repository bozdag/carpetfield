package com.carpetfield.server.controller;

import com.carpetfield.server.service.UserService;
import com.carpetfield.server.web.UserCreateForm;
import com.carpetfield.server.web.validator.UserCreateFormValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.NoSuchElementException;

/**
 * Created by selcukb on 09.03.2017.
 */
@Controller
public class UsersController
{
    private final UserService userService;
    private final UserCreateFormValidator userCreateFormValidator;

    @Autowired
    public UsersController(UserService userService, UserCreateFormValidator userCreateFormValidator)
    {
        this.userService = userService;
        this.userCreateFormValidator = userCreateFormValidator;
    }

    @InitBinder("form")
    public void initBinder(WebDataBinder dataBinder)
    {
        dataBinder.addValidators(userCreateFormValidator);
    }

    @RequestMapping("/user/{id}")
    public ModelAndView user(@PathVariable Long id)
    {
        return new ModelAndView("user", "user", userService.getUserById(id)
                    .orElseThrow(() -> new NoSuchElementException(String.format("User: %d not found", id))));
    }

    @RequestMapping("/users")
    public ModelAndView all()
    {
        return new ModelAndView("users", "users", userService.getAllUsers());
    }

    @PreAuthorize("@currentUserServiceImpl.canAccessUser(principal, #id)")
    @RequestMapping(value = "/user/create", method = RequestMethod.GET)
    public ModelAndView getUserCreatePage()
    {
        return new ModelAndView("user_create", "form", new UserCreateForm());
    }

    @PreAuthorize("@currentUserServiceImpl.canAccessUser(principal, #id)")
    @RequestMapping(value = "/user/create", method = RequestMethod.POST)
    public String handleUserCreateForm(@Valid @ModelAttribute("form") UserCreateForm form, BindingResult bindingResult)
    {
        if (bindingResult.hasErrors())
        {
            return "user_create";
        }
        try
        {
            userService.create(form);
        }
        catch (DataIntegrityViolationException e)
        {
            bindingResult.reject("error.email.duplicate", "Email address is already used");
            return "user_create";
        }
        return "redirect:/users";
    }
}
