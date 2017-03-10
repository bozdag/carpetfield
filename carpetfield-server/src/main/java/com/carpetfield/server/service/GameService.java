package com.carpetfield.server.service;

import com.carpetfield.server.domain.Game;
import java.util.Collection;
import java.util.Optional;

/**
 * Created by seckink on 3/9/2017.
 */
public interface GameService
{
    Optional<Game> getGameById(long id);
    Collection<Game> getGamesByOrganizationId(long orgId);
    Collection<Game> getAllGames();
    Game createOrUpdate(Game game);
    void deleteGameById(long id);
}
