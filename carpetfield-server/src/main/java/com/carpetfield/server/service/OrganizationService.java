package com.carpetfield.server.service;

import com.carpetfield.server.domain.Game;
import com.carpetfield.server.domain.Organization;
import com.carpetfield.server.domain.OrganizationMembership;
import com.carpetfield.server.domain.Team;
import com.carpetfield.server.domain.User;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

/**
 * Created by alicana on 09/03/2017.
 */

public interface OrganizationService {

  List<Organization> findAll();

  Optional<Organization> findOne(Long id);

  Optional<Organization> findByName(String organizationName);

  Organization saveAndFlush(Organization organization);

  Collection<Game> findGamesOfOrganization(long orgId);

  Game findGameOfOrganizationByGameId(long orgId, long gameId);

  Collection<User> findPlayersOfOrganizationGameByGameId(long orgId, long gameId);

  User findPlayerOfOrganizationGameByPlayerId(long orgId, long gameId, long playerId);

  Collection<Team> findTeamsOfOrganizationGameByGameId(long orgId, long gameId);

  Team findTeamOfOrganizationGameByTeamId(long orgId, long gameId, long teamId);

  Collection<User> findUsersOfOrganizationGameTeamByTeamId(long orgId, long gameId, long teamId);

  Collection<OrganizationMembership> findUsersOfOrganizationByOrgId(long orgId);
}
