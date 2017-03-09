package com.carpetfield.server.service.auth;

import com.carpetfield.server.domain.auth.CurrentUser;

/**
 * Created by selcukb on 09.03.2017.
 */
public interface CurrentUserService
{
    boolean canAccessUser(CurrentUser currentUser, Long userId);
}
