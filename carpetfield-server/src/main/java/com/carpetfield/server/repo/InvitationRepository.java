package com.carpetfield.server.repo;

import com.carpetfield.server.domain.Invitation;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by seckink on 3/10/2017.
 */
public interface InvitationRepository extends JpaRepository<Invitation, Long>
{

}
