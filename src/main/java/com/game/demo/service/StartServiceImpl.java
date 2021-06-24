package com.game.demo.service;

import com.game.demo.dto.request.CreateGameRequest;
import com.game.demo.dto.request.JoinGameRequest;
import com.game.demo.dto.response.ResponseBuilder;
import com.game.demo.model.Game;
import com.game.demo.model.Player;
import com.game.demo.model.enums.Color;
import com.game.demo.repository.GameRepository;
import com.game.demo.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.Random;

@Service
public class StartServiceImpl implements StartService {

    private PlayerRepository playerRepository;

    private GameRepository gameRepository;

    @Autowired
    public void setPlayerRepository (PlayerRepository playerRepository) { this.playerRepository = playerRepository;}

    @Autowired
    public void setGameRepository (GameRepository gameRepository) { this.gameRepository = gameRepository;}

    @Override
    public ResponseEntity<?> initGame(CreateGameRequest createPlayerRequest) {
        String gameIdString = generateGameIdString();

        Player player = createPlayer(createPlayerRequest.getUsername());
        Game game = createGame(player, gameIdString);

        player.setGame(game);
        game.getPlayers().add(player);

        gameRepository.save(game);
        playerRepository.save(player);

        return ResponseEntity.ok(ResponseBuilder.gameResponse(game));
    }

    @Override
    public ResponseEntity<?> joinGame(JoinGameRequest joinGameRequest) {
        String gameIdString = joinGameRequest.getGameIdString();

        Game game = gameRepository.findByGameIdString(gameIdString)
                .orElseThrow(() -> new EntityNotFoundException("Game with: " + gameIdString + " does not exist."));

        Player player = createPlayer(joinGameRequest.getUsername());
        player.setGame(game);

        playerRepository.save(player);

        game.getPlayers().add(player);

        gameRepository.save(game);
        playerRepository.save(player);

        return ResponseEntity.ok(ResponseBuilder.gameResponse(game));
    }


    public Player createPlayer (String username) {
        Player player = new Player();

        player.setName(username);
        player.setColor(Color.RED);

        return player;
    }

    public Player createPlayer (String username, Game game) {
        Player player = new Player();

        player.setName(username);
        player.setColor(Color.RED);

        return player;
    }

    public Game createGame (Player player, String gameIdString) {
        Game game = new Game();

        game.getPlayers().add(player);
        game.setGameIdString(gameIdString);

        return game;
    }


    public String generateGameIdString() {
        String gameIdString ="placeholder";
        boolean uniqueGameIdString = false;

        int leftLimit = 66; // letter 'A'
        int rightLimit = 122; // letter 'z'
        int targetStringLength = 3;
        Random random = new Random();

        // loops until unique String is generated
        while (!uniqueGameIdString) {
            gameIdString = random.ints(leftLimit, rightLimit + 1)
                    .filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97))
                    .limit(targetStringLength)
                    .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                    .toString();

            if (Boolean.FALSE.equals(gameRepository.existsByGameIdString(gameIdString))) {
                uniqueGameIdString = true;
            }
        }
        return gameIdString;
    }


}
