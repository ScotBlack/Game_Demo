package com.game.demo.dto.response;

import com.game.demo.model.Game;
import com.game.demo.model.Player;

import java.util.HashSet;
import java.util.Set;

public class ResponseBuilder {

    public static GameResponse gameResponse (Game game) {
        return new GameResponse(
            game.getGameIdString(),
            playerResponseSet(game)
        );
    }

    public static PlayerResponse playerResponse (Player player) {
        return new PlayerResponse(
                player.getName(),
                player.getColor()
        );
    }


    public static Set<PlayerResponse> playerResponseSet(Game game) {
        Set<PlayerResponse> playerResponses = new HashSet<>();

        for (Player player : game.getPlayers()) {
            playerResponses.add(playerResponse(player));
        }
        return playerResponses;
    }
}
