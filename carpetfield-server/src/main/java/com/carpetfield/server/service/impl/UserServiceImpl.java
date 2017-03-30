package com.carpetfield.server.service.impl;

import com.carpetfield.server.repo.RoleRepository;
import java.util.Collection;
import java.util.NoSuchElementException;
import java.util.Optional;

import com.carpetfield.server.domain.Game;
import com.carpetfield.server.domain.Invitation;
import com.carpetfield.server.domain.OrganizationMembership;
import com.carpetfield.server.domain.User;
import com.carpetfield.server.repo.UserRepository;
import com.carpetfield.server.repo.InvitationRepository;
import com.carpetfield.server.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * Created by selcukb on 09.03.2017.
 */
@Service
public class UserServiceImpl implements UserService
{
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private InvitationRepository invitationRepository;

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
    public User createOrUpdate(User user)
    {
        return userRepository.save(user);
    }

    @Override
    public void deleteUserById(long id)
    {
        userRepository.delete(id);
    }

    @Override
    public Collection<OrganizationMembership> findOrganizationsOfUser(long usrId){
        User user = userRepository.findOne(usrId);
        if(user != null){
            return user.getMemberships();
        }
        else{
            throw new NoSuchElementException("User not found!");
        }
    }

    @Override
    public Collection<Game> findGamesOfUser(long usrId){
        User user = userRepository.findOne(usrId);
        if(user != null){
            return user.getGameCollection();
        }
        else{
            throw new NoSuchElementException("User not found!");
        }
    }

    @Override
    public Collection<Invitation> findInvitationsOfUser(long usrId){
        return invitationRepository.findByUserId(usrId);
    }

}
