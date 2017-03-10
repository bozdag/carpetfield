package com.carpetfield.server.controller;

import com.carpetfield.server.domain.Invitation;
import com.carpetfield.server.service.InvitationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collection;
import java.util.NoSuchElementException;

/**
 * Created by seckink on 3/10/2017.
 */
@RestController
@RequestMapping("/invitations")
public class InvitationController {

    @Autowired
    private InvitationService invitationService;

    /* GET /invitations */
    @RequestMapping(method = RequestMethod.GET)
    public Collection<Invitation> list()
    {
        return invitationService.getAllInvitations();
    }

    /* GET /invitations/1 */
    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public Invitation getInvitation(@PathVariable Long id)
    {
        return invitationService.getInvitationById(id).orElseThrow( () -> new NoSuchElementException("Invitation not found"));
    }

    /* POST /invitations {invitation data} */
    @RequestMapping(method = RequestMethod.POST)
    public Invitation createInvitation(@RequestBody @Valid final Invitation invitation)
    {
        return invitationService.createOrUpdate(invitation);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Long id)
    {
        invitationService.deleteInvitationById(id);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    public Invitation update(@PathVariable Long id, @RequestBody @Valid final Invitation invitation)
    {
        Invitation invitationToUpdate = invitationService.getInvitationById(id).orElseThrow( () -> new NoSuchElementException("User not found"));
        // MARK: <Alternative> BeanUtils.copyProperties
        invitationToUpdate.setContext( invitation.getContext() );
        return invitationService.createOrUpdate( invitationToUpdate );
    }
}
