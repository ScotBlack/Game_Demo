package com.game.demo.dto.response;

import com.game.demo.model.enums.Color;

import javax.persistence.Column;

public class PlayerResponse {

    private String name;

    private Color color;

    public PlayerResponse(String name, Color color) {
        this.name = name;
        this.color = color;
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
}
