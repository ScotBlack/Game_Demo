package com.game.demo.model;

import com.game.demo.model.enums.GameType;
import org.springframework.beans.factory.annotation.Value;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table (name="game")
public class Game {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String gameIdString;

    // (in)game
    @OneToMany (mappedBy = "game")
    private Set<Player> players;

    @ManyToOne
    private MiniGame currentMiniGame;

    @OneToMany
    private Set<Player> competingPlayers;

    // status
    @Column
    @Value("false")
    private Boolean started;

    @Column
    private String lobbyStatus;

    @Column
    @Value("false")
    private Boolean canStart;

    // game settings
    @Column
    private GameType gameType;

    @Column
    private int scoreToWin;


    public Game() {
        this.gameType = GameType.FFA;
        this.scoreToWin = 100;
        this.players = new HashSet<>();
        this.competingPlayers = new HashSet<>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGameIdString() {
        return gameIdString;
    }

    public void setGameIdString(String gameIdString) {
        this.gameIdString = gameIdString;
    }

    public Set<Player> getPlayers() {
        return players;
    }

    public void setPlayers(Set<Player> players) {
        this.players = players;
    }

    public MiniGame getCurrentMiniGame() {
        return currentMiniGame;
    }

    public void setCurrentMiniGame(MiniGame currentMiniGame) {
        this.currentMiniGame = currentMiniGame;
    }

    public Set<Player> getCompetingPlayers() {
        return competingPlayers;
    }

    public void setCompetingPlayers(Set<Player> competingPlayers) {
        this.competingPlayers = competingPlayers;
    }

    public Boolean getStarted() {
        return started;
    }

    public void setStarted(Boolean started) {
        this.started = started;
    }

    public String getLobbyStatus() {
        return lobbyStatus;
    }

    public void setLobbyStatus(String lobbyStatus) {
        this.lobbyStatus = lobbyStatus;
    }

    public Boolean getCanStart() {
        return canStart;
    }

    public void setCanStart(Boolean canStart) {
        this.canStart = canStart;
    }

    public GameType getGameType() {
        return gameType;
    }

    public void setGameType(GameType gameType) {
        this.gameType = gameType;
    }

    public int getScoreToWin() {
        return scoreToWin;
    }

    public void setScoreToWin(int scoreToWin) {
        this.scoreToWin = scoreToWin;
    }
}
