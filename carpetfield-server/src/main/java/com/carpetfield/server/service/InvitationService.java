package com.carpetfield.server.service;

import com.carpetfield.server.domain.Invitation;

import java.util.Collection;
import java.util.Optional;

/**
 * Created by seckink on 3/10/2017.
 */
public interface InvitationService
{
    Optional<Invitation> getInvitationById(long id);
    Collection<Invitation> getAllInvitations();
    Invitation createOrUpdate(Invitation invitation);
    void deleteInvitationById(long id);
}
