package com.game.demo.controller;

import com.game.demo.dto.CreatePlayerRequest;
import com.game.demo.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/player")
public class PlayerController {

    private PlayerService playerService;

    @Autowired
    public void setPlayerService (PlayerService playerService) { this.playerService = playerService;}


    @PostMapping(path="/createPlayer")
    public ResponseEntity<?> createPlayer (@Valid @RequestBody CreatePlayerRequest createPlayerRequest) {
        return playerService.createPlayer(createPlayerRequest);
    }

}
