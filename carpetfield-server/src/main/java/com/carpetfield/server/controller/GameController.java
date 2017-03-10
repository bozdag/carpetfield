package com.carpetfield.server.controller;

import com.carpetfield.server.domain.Game;
import com.carpetfield.server.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collection;
import java.util.NoSuchElementException;

/**
 * Created by seckink on 3/10/2017.
 */
@RestController
@RequestMapping("/games")
public class GameController {
    @Autowired
    private GameService gameService;

    /* GET /users */
    @RequestMapping(method = RequestMethod.GET)
    public Collection<Game> list()
    {
        return gameService.getAllGames();
    }

    /* GET /users/1 */
    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public Game getGame(@PathVariable Long id)
    {
        return gameService.getGameById(id).orElseThrow( () -> new NoSuchElementException("Game not found"));
    }

    /* POST /users {user data} */
    @RequestMapping(method = RequestMethod.POST)
    public Game createGame(@RequestBody @Valid final Game game)
    {
        return gameService.createOrUpdate(game);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Long id)
    {
        gameService.deleteGameById(id);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    public Game update(@PathVariable Long id, @RequestBody @Valid final Game game)
    {
        Game gameToUpdate = gameService.getGameById(id).orElseThrow( () -> new NoSuchElementException("User not found"));
        // MARK: <Alternative> BeanUtils.copyProperties
        gameToUpdate.setName( game.getName() );
        gameToUpdate.setDescription( game.getDescription() );
        gameToUpdate.setAddress( game.getAddress() );
        return gameService.createOrUpdate( gameToUpdate );
    }
}
