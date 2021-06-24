package com.game.demo.dto.response;

import java.util.Set;

public class GameResponse {

    private String gameIdString;
    private Set<PlayerResponse> players;

    public GameResponse(String gameIdString, Set<PlayerResponse> players) {
        this.gameIdString = gameIdString;
        this.players = players;
    }

    public String getGameIdString() {
        return gameIdString;
    }

    public void setGameIdString(String gameIdString) {
        this.gameIdString = gameIdString;
    }

    public Set<PlayerResponse> getPlayers() {
        return players;
    }

    public void setPlayers(Set<PlayerResponse> players) {
        this.players = players;
    }
}
