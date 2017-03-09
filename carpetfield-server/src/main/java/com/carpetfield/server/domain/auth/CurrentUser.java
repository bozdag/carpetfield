package com.carpetfield.server.domain.auth;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.*;

import java.util.Collection;

/**
 * Created by selcukb on 09.03.2017.
 */
public class CurrentUser extends org.springframework.security.core.userdetails.User
{
    private User user;

    public CurrentUser(User user)
    {
        super(user.getEmail(), user.getPasswordHash(), AuthorityUtils.createAuthorityList(user.getRole().toString()));
        this.user = user;
    }

    public User getUser()
    {
        return user;
    }

    public Long getId()
    {
        return user.getId();
    }

    public Role getRole()
    {
        return user.getRole();
    }

}
