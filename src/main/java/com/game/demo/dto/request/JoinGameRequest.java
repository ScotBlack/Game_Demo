package com.game.demo.dto.request;


import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class JoinGameRequest {

    @Size(min = 3 , max = 12, message = "Username length must be between 3 and 12 characters long.")
    private String username;

    @NotBlank
    private String gameIdString;

    public String getUsername() {return username;}
    public void setUsername(String username) {this.username = username;}

    public String getGameIdString() {return gameIdString;}
    public void setGameIdString(String gameIdString) {this.gameIdString = gameIdString;}
}
