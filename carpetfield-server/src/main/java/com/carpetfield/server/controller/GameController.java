package com.carpetfield.server.controller;

import java.util.Collection;
import java.util.NoSuchElementException;

import javax.validation.Valid;

import com.carpetfield.server.domain.Game;
import com.carpetfield.server.domain.Invitation;
import com.carpetfield.server.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by seckink on 3/10/2017.
 */
@RestController
@RequestMapping("/games")
@EnableAutoConfiguration
public class GameController {
	@Autowired private GameService gameService;

	/* GET /games */
	@RequestMapping(method = RequestMethod.GET)
	public Collection<Game> list() {
		return gameService.getAllGames();
	}

	/* GET /games/1 */
	@RequestMapping(value = "{id}", method = RequestMethod.GET)
	public Game getGame(@PathVariable Long id) {
		return gameService.getGameById(id).orElseThrow(() -> new NoSuchElementException("Game not found"));
	}

	/* POST /games {game data} */
	@RequestMapping(method = RequestMethod.POST)
	public Game createGame(@RequestBody @Valid final Game game) {
		return gameService.createOrUpdate(game);
	}

	@RequestMapping(value = "{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable Long id) {
		gameService.deleteGameById(id);
	}

	@RequestMapping(value = "{id}", method = RequestMethod.PUT)
	public Game update(@PathVariable Long id, @RequestBody @Valid final Game game) {
		Game gameToUpdate = gameService.getGameById(id).orElseThrow(() -> new NoSuchElementException("Game not found"));
		// MARK: <Alternative> BeanUtils.copyProperties
		gameToUpdate.setName(game.getName());
		gameToUpdate.setDescription(game.getDescription());
		gameToUpdate.setAddress(game.getAddress());
		return gameService.createOrUpdate(gameToUpdate);
	}

	/* GET /games/1/invitations */
	@RequestMapping(value = "{id}/invitations", method = RequestMethod.GET)
	public Collection<Invitation> getGameInvitations(@PathVariable Long id)
	{
		return gameService.getInvitationsByGameId(id);
	}
}
