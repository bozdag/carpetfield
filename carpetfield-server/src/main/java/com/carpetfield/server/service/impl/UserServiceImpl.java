package com.carpetfield.server.service.impl;

import java.util.Collection;
import java.util.Optional;

import com.carpetfield.server.domain.auth.User;
import com.carpetfield.server.repo.UserRepository;
import com.carpetfield.server.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

/**
 * Created by selcukb on 09.03.2017.
 */
@Service
public class UserServiceImpl implements UserService
{
    @Autowired
    private UserRepository userRepository;

    @Override
    public Optional<User> getUserById(long id)
    {
        return Optional.ofNullable(userRepository.findOne(id));
    }

    @Override
    public Optional<User> getUserByEmail(String email)
    {
        return userRepository.findOneByEmail(email);
    }

    @Override
    public Collection<User> getAllUsers()
    {
        return userRepository.findAll(new Sort("email"));
    }

    @Override
    public User create(User user)
    {
        return userRepository.save(user);
    }
}
