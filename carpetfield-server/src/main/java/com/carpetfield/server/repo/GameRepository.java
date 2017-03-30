package com.carpetfield.server.repo;

import com.carpetfield.server.domain.Game;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by seckink on 3/9/2017.
 */
public interface GameRepository extends JpaRepository<Game, Long> {

}
