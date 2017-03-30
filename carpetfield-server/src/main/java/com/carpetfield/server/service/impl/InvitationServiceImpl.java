package com.carpetfield.server.service.impl;

import com.carpetfield.server.domain.Invitation;
import com.carpetfield.server.repo.InvitationRepository;
import com.carpetfield.server.service.InvitationService;
import java.util.Collection;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by seckink on 3/10/2017.
 */
@Service
public class InvitationServiceImpl implements InvitationService {

  @Autowired
  private InvitationRepository invitationRepository;

  @Override
  public Optional<Invitation> getInvitationById(long id) {
    return Optional.ofNullable(invitationRepository.findOne(id));
  }

  @Override
  public Collection<Invitation> getAllInvitations() {
    return invitationRepository.findAll();
  }

  @Override
  public Invitation createOrUpdate(Invitation invitation) {
    return invitationRepository.save(invitation);
  }

  @Override
  public void deleteInvitationById(long id) {
    invitationRepository.delete(id);
  }
}
