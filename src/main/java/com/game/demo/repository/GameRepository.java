package com.game.demo.repository;

import com.game.demo.model.Game;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface GameRepository extends JpaRepository<Game, Long> {
    Boolean existsByGameIdString(String gameIdString);
    Optional<Game> findByGameIdString(String gameIdString);
}
