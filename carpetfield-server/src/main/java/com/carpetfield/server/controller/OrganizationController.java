package com.carpetfield.server.controller;

import java.util.List;
import java.util.Collection;
import java.util.NoSuchElementException;

import com.carpetfield.server.domain.Organization;
import com.carpetfield.server.domain.Game;
import com.carpetfield.server.domain.OrganizationMembership;
import com.carpetfield.server.domain.Team;
import com.carpetfield.server.domain.auth.User;
import com.carpetfield.server.service.OrganizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;

/**
 * Created by alicana on 09/03/2017.
 */
@RestController
@RequestMapping("/organizations")
@EnableAutoConfiguration
public class OrganizationController {

	@Autowired
	private OrganizationService organizationService;

	@RequestMapping(method = RequestMethod.GET)
	public List<Organization> list() {
		return organizationService.findAll();
	}

	@ApiOperation(value = "getOrganization", nickname = "getOrganization")
	@RequestMapping(value = "{id}", method = RequestMethod.GET)
	public Organization getOrganization(@PathVariable Long id) {
		return organizationService.findOne(id).orElseThrow(() -> new NoSuchElementException("Organization not found!"));
	}

	@RequestMapping(method = RequestMethod.POST)
	public Organization addOrganization(@RequestBody Organization organization){
		return organizationService.saveAndFlush(organization);
	}

	@RequestMapping(value = "{id}/games", method = RequestMethod.GET)
	public Collection<Game> getOrganizationGames(@PathVariable Long id) {
        return organizationService.findGamesOfOrganization(id);
	}

	@RequestMapping(value = "{id}/games/{game_id}", method = RequestMethod.GET)
	public Game getOrganizationGameById(@PathVariable Long id, @PathVariable Long game_id) {
        return organizationService.findGameOfOrganizationByGameId(id,game_id);
	}

	@RequestMapping(value = "{id}/games/{game_id}/players", method = RequestMethod.GET)
	public Collection<User> getOrganizationGamePlayersByGameId(@PathVariable Long id, @PathVariable Long game_id) {
		return organizationService.findPlayersOfOrganizationGameByGameId(id,game_id);
	}

	@RequestMapping(value = "{id}/games/{game_id}/players/{player_id}", method = RequestMethod.GET)
	public User getOrganizationGamePlayerByPlayerId(@PathVariable Long id, @PathVariable Long game_id, @PathVariable Long player_id) {
		return organizationService.findPlayerOfOrganizationGameByPlayerId(id,game_id,player_id);
	}

	@RequestMapping(value = "{id}/games/{game_id}/teams", method = RequestMethod.GET)
	public Collection<Team> getOrganizationGameTeamsByGameId(@PathVariable Long id, @PathVariable Long game_id) {
		return organizationService.findTeamsOfOrganizationGameByGameId(id, game_id);
	}

	@RequestMapping(value = "{id}/games/{game_id}/teams/{team_id}", method = RequestMethod.GET)
	public Team getOrganizationGameTeamByTeamId(@PathVariable Long id, @PathVariable Long game_id, @PathVariable Long team_id) {
		return organizationService.findTeamOfOrganizationGameByTeamId(id,game_id,team_id);
	}

	@RequestMapping(value = "{id}/games/{game_id}/teams/{team_id}/players", method = RequestMethod.GET)
	public Collection<User> getOrganizationGameTeamPlayersByTeamId(@PathVariable Long id, @PathVariable Long game_id, @PathVariable Long team_id) {
		return organizationService.findUsersOfOrganizationGameTeamByTeamId(id,game_id,team_id);
	}

	@RequestMapping(value = "{id}/users", method = RequestMethod.GET)
	public Collection<OrganizationMembership> getOrganizationUsersByOrgId(@PathVariable Long id) {
		return organizationService.findUsersOfOrganizationByOrgId(id);
	}
}
