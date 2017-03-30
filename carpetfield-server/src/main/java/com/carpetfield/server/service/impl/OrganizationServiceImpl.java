package com.carpetfield.server.service.impl;

import com.carpetfield.server.domain.Game;
import com.carpetfield.server.domain.Organization;
import com.carpetfield.server.domain.OrganizationMembership;
import com.carpetfield.server.domain.Team;
import com.carpetfield.server.domain.User;
import com.carpetfield.server.repo.OrganizationRepository;
import com.carpetfield.server.service.OrganizationService;
import java.util.Collection;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by alicana on 09/03/2017.
 */
@Service
public class OrganizationServiceImpl implements OrganizationService {

  @Autowired
  private OrganizationRepository organizationRepository;

  @Override
  public List<Organization> findAll() {
    return organizationRepository.findAll();
  }

  @Override
  public Optional<Organization> findOne(Long id) {
    return Optional.ofNullable(organizationRepository.findOne(id));
  }

  @Override
  public Optional<Organization> findByName(String organizationName) {
    return organizationRepository.findByNameIgnoreCase(organizationName);
  }

  @Override
  public Organization saveAndFlush(Organization organization) {
    return organizationRepository.saveAndFlush(organization);
  }

  @Override
  public Collection<Game> findGamesOfOrganization(long orgId) {
    return organizationRepository.findOne(orgId).getOrganizationGames();
  }

  private Game findGame(Collection<Game> orgGames, Long game_id) {
    for (Game g : orgGames) {
      if (g.getId() == game_id) {
        return g;
      }
    }

    throw new NoSuchElementException("Organization game not found!");
  }

  @Override
  public Game findGameOfOrganizationByGameId(long orgId, long gameId) {
    Organization org = organizationRepository.findOne(orgId);
    return this.findGame(org.getOrganizationGames(), gameId);
  }

  @Override
  public Collection<User> findPlayersOfOrganizationGameByGameId(long orgId, long gameId) {
    Organization org = organizationRepository.findOne(orgId);
    return this.findGame(org.getOrganizationGames(), gameId).getUserCollection();
  }

  private User findUser(Collection<User> gameUsers, Long user_id) {
    for (User u : gameUsers) {
      if (u.getId() == user_id) {
        return u;
      }
    }

    throw new NoSuchElementException("Organization game player not found!");
  }

  @Override
  public User findPlayerOfOrganizationGameByPlayerId(long orgId, long gameId, long playerId) {
    Organization org = organizationRepository.findOne(orgId);
    Game game = this.findGame(org.getOrganizationGames(), gameId);
    User player = this.findUser(game.getUserCollection(), playerId);
    return player;
  }


  @Override
  public Collection<Team> findTeamsOfOrganizationGameByGameId(long orgId, long gameId) {
    Organization org = organizationRepository.findOne(orgId);
    Game game = this.findGame(org.getOrganizationGames(), gameId);
    return game.getGameTeams();
  }

  private Team findTeam(Collection<Team> gameTeams, Long team_id) {
    for (Team t : gameTeams) {
      if (t.getId() == team_id) {
        return t;
      }
    }

    throw new NoSuchElementException("Organization game team not found!");
  }

  @Override
  public Team findTeamOfOrganizationGameByTeamId(long orgId, long gameId, long teamId) {
    Organization org = organizationRepository.findOne(orgId);
    Game game = this.findGame(org.getOrganizationGames(), gameId);
    Team team = this.findTeam(game.getGameTeams(), teamId);
    return team;
  }

  @Override
  public Collection<User> findUsersOfOrganizationGameTeamByTeamId(long orgId, long gameId,
      long teamId) {
    Organization org = organizationRepository.findOne(orgId);
    Game game = this.findGame(org.getOrganizationGames(), gameId);
    Team team = this.findTeam(game.getGameTeams(), teamId);
    return team.getUserCollection();
  }

  @Override
  public Collection<OrganizationMembership> findUsersOfOrganizationByOrgId(long orgId) {
    Organization org = organizationRepository.findOne(orgId);
    return org.getMembers();
  }
}
