package com.carpetfield.server.repo;

import com.carpetfield.server.domain.Invitation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;

/**
 * Created by seckink on 3/10/2017.
 */
public interface InvitationRepository extends JpaRepository<Invitation, Long>
{
    public Collection<Invitation> findByGameId(long gameId);

    public Collection<Invitation> findByUserId(long userId);
}
