package com.carpetfield.server.service;

import com.carpetfield.server.domain.auth.User;
import com.carpetfield.server.web.UserCreateForm;

import java.util.Collection;
import java.util.Optional;

/**
 * Created by selcukb on 09.03.2017.
 */
public interface UserService
{
    Optional<User> getUserById(long id);
    Optional<User> getUserByEmail(String email);
    Collection<User> getAllUsers();
    User create(UserCreateForm form);
}
