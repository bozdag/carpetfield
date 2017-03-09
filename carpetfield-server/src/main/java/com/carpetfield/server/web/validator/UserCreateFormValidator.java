package com.carpetfield.server.web.validator;


import com.carpetfield.server.service.UserService;
import com.carpetfield.server.web.UserCreateForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 * Created by selcukb on 09.03.2017.
 */
@Component
public class UserCreateFormValidator implements Validator
{
    private final UserService userService;

    @Autowired
    public UserCreateFormValidator(UserService userService)
    {
        this.userService = userService;
    }

    @Override
    public boolean supports(Class<?> aClass)
    {
        return aClass.equals(UserCreateForm.class);
    }

    @Override
    public void validate(Object target, Errors errors)
    {
        UserCreateForm form = (UserCreateForm) target;
        validatePasswords(errors, form);
        validateEmail(errors, form);
    }

    /* Validations */
    private void validatePasswords(final Errors errors, final UserCreateForm form)
    {
        if (!form.getPassword().equals(form.getPasswordRepeated()))
        {
            errors.reject("error.password.no_match", "Passwords do not match");
        }
    }

    private void validateEmail(final Errors errors, final UserCreateForm form)
    {
        String address  = form.getEmail();

        if (address == null || address.isEmpty() )
        {
            errors.reject("error.email.empty", "Email address can not be empty");
        }

        if (userService.getUserByEmail(address).isPresent())
        {
            errors.reject("error.email.duplicate", "Email address is already used");
        }
    }

}
