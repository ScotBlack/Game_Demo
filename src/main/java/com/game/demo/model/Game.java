package com.game.demo.model;

import com.game.demo.model.enums.GameType;
import org.springframework.beans.factory.annotation.Value;

import javax.persistence.*;
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







}
