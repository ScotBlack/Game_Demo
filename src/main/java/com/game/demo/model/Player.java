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
}
