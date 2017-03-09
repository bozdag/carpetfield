package com.carpetfield.server.service.auth;

import com.carpetfield.server.domain.auth.CurrentUser;
import com.carpetfield.server.domain.auth.Role;
import org.springframework.stereotype.Service;

/**
 * Created by selcukb on 09.03.2017.
 */
@Service
public class CurrentUserServiceImpl implements CurrentUserService
{
    @Override
    public boolean canAccessUser(CurrentUser currentUser, Long userId)
    {
        return currentUser != null
                && (currentUser.getRole() == Role.ADMIN || currentUser.getId().equals(userId));
    }
}
