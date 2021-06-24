package com.game.demo.controller;

import com.game.demo.dto.request.CreateGameRequest;
import com.game.demo.dto.request.JoinGameRequest;
import com.game.demo.service.StartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/start")
public class StartController {

    private StartService startService;

    @Autowired
    public void setPlayerService (StartService startService) { this.startService = startService;}

    @GetMapping(path= "/test")
    public ResponseEntity<?> test () {
        return ResponseEntity.ok("test");
    }


    @PostMapping(path="/initGame")
    public ResponseEntity<?> createPlayer (@Valid @RequestBody CreateGameRequest createGameRequest) {
        return startService.initGame(createGameRequest);
    }

    @PostMapping(path="/joinGame")
    public ResponseEntity<?> joinGame (@Valid @RequestBody JoinGameRequest joinGameRequest) {
        return startService.joinGame(joinGameRequest);
    }
}
