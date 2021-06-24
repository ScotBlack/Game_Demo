package com.game.demo.model;


import com.game.demo.model.enums.Color;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Player {

    @Id
    @GeneratedValue(
            strategy= GenerationType.AUTO,
            generator="native"
    )
    @GenericGenerator(
            name = "native",
            strategy = "native"
    )
    @Column(columnDefinition = "serial")
    private Long id;

    @ManyToOne
    @JoinColumn(name="game_id")
    private Game game;

    @Column
    private String name;

    @Column
    private Color color;

    @ElementCollection
    private Set<String> teamMembers;

    @Column
    private Boolean hasAnswered;

    @Column
    private int points;

    public Player() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Set<String> getTeamMembers() {
        return teamMembers;
    }

    public void setTeamMembers(Set<String> teamMembers) {
        this.teamMembers = teamMembers;
    }

    public Boolean getHasAnswered() {
        return hasAnswered;
    }

    public void setHasAnswered(Boolean hasAnswered) {
        this.hasAnswered = hasAnswered;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }
}
