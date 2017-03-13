package com.carpetfield.server.controller;

import java.util.List;
import java.util.Collection;
import java.util.NoSuchElementException;

import com.carpetfield.server.domain.Organization;
import com.carpetfield.server.domain.Game;
import com.carpetfield.server.domain.Team;
import com.carpetfield.server.domain.auth.User;
import com.carpetfield.server.service.OrganizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by alicana on 09/03/2017.
 */
@RestController
@RequestMapping("/organizations")
public class OrganizationController {

	@Autowired
	private OrganizationService organizationService;

	@RequestMapping(method = RequestMethod.GET)
	public List<Organization> list() {
		return organizationService.findAll();
	}

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
		Organization org = organizationService.findOne(id).orElseThrow(() -> new NoSuchElementException("Organization not found!"));
		return org.getOrganizationGames();
	}

	private Game findGame(Collection<Game> orgGames, Long game_id)
	{
		for(Game g:orgGames){
			if(g.getId() == game_id){
				return g;
			}
		}

		throw new NoSuchElementException("Organization game not found!");
	}

	@RequestMapping(value = "{id}/games/{game_id}", method = RequestMethod.GET)
	public Game getOrganizationGameById(@PathVariable Long id, @PathVariable Long game_id) {
		Organization org = organizationService.findOne(id).orElseThrow(() -> new NoSuchElementException("Organization not found!"));
		return this.findGame(org.getOrganizationGames(), game_id);
	}

	@RequestMapping(value = "{id}/games/{game_id}/players", method = RequestMethod.GET)
	public Collection<User> getOrganizationGamePlayersByGameId(@PathVariable Long id, @PathVariable Long game_id) {
		Organization org = organizationService.findOne(id).orElseThrow(() -> new NoSuchElementException("Organization not found!"));
		Game game = this.findGame(org.getOrganizationGames(), game_id);
		return game.getUserCollection();
	}

	private User findUser(Collection<User> gameUsers, Long user_id)
	{
		for(User u:gameUsers){
			if(u.getId() == user_id){
				return u;
			}
		}

		throw new NoSuchElementException("Organization game player not found!");
	}

	@RequestMapping(value = "{id}/games/{game_id}/players/{player_id}", method = RequestMethod.GET)
	public User getOrganizationGamePlayerByPlayerId(@PathVariable Long id, @PathVariable Long game_id, @PathVariable Long player_id) {
		Organization org = organizationService.findOne(id).orElseThrow(() -> new NoSuchElementException("Organization not found!"));
		Game game = this.findGame(org.getOrganizationGames(), game_id);
		return this.findUser(game.getUserCollection(), player_id);
	}

	@RequestMapping(value = "{id}/games/{game_id}/teams", method = RequestMethod.GET)
	public Collection<Team> getOrganizationGameTeamsByGameId(@PathVariable Long id, @PathVariable Long game_id) {
		Organization org = organizationService.findOne(id).orElseThrow(() -> new NoSuchElementException("Organization not found!"));
		Game game = this.findGame(org.getOrganizationGames(), game_id);
		return game.getGameTeams();
	}

	private Team findTeam(Collection<Team> gameTeams, Long team_id)
	{
		for(Team t:gameTeams){
			if(t.getId() == team_id){
				return t;
			}
		}

		throw new NoSuchElementException("Organization game team not found!");
	}

	@RequestMapping(value = "{id}/games/{game_id}/teams/{team_id}", method = RequestMethod.GET)
	public Team getOrganizationGameTeamByTeamId(@PathVariable Long id, @PathVariable Long game_id, @PathVariable Long team_id) {
		Organization org = organizationService.findOne(id).orElseThrow(() -> new NoSuchElementException("Organization not found!"));
		Game game = this.findGame(org.getOrganizationGames(), game_id);
		return this.findTeam(game.getGameTeams(), team_id);
	}

	@RequestMapping(value = "{id}/games/{game_id}/teams/{team_id}/players", method = RequestMethod.GET)
	public Collection<User> getOrganizationGameTeamPlayersByTeamId(@PathVariable Long id, @PathVariable Long game_id, @PathVariable Long team_id) {
		Organization org = organizationService.findOne(id).orElseThrow(() -> new NoSuchElementException("Organization not found!"));
		Game game = this.findGame(org.getOrganizationGames(), game_id);
		Team team = this.findTeam(game.getGameTeams(), team_id);
		return team.getUserCollection();
	}
}
