package com.carpetfield.server.service.impl;

import java.util.Collection;
import java.util.Optional;

import com.carpetfield.server.domain.Game;
import com.carpetfield.server.domain.Invitation;
import com.carpetfield.server.repo.GameRepository;
import com.carpetfield.server.repo.InvitationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import com.carpetfield.server.service.GameService;
/**
 * Created by seckink on 3/9/2017.
 */
@Service
public class GameServiceImpl implements GameService
{
    @Autowired
    private GameRepository gameRepository;

    @Autowired
    private InvitationRepository invitationRepository;

    @Override
    public Optional<Game> getGameById(long id)
    {
        return Optional.ofNullable(gameRepository.findOne(id));
    }

    @Override
    public Collection<Invitation> getInvitationsByGameId(long gameId)
    {
        return invitationRepository.findByGameId(gameId);
    }

    @Override
    public Collection<Game> getAllGames()
    {
        return gameRepository.findAll(new Sort("name"));
    }

    @Override
    public Game createOrUpdate(Game game)
    {
        return gameRepository.save(game);
    }

    @Override
    public void deleteGameById(long id)
    {
        gameRepository.delete(id);
    }

}
