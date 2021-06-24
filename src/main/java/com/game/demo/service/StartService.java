package com.game.demo.service;

import com.game.demo.dto.request.CreateGameRequest;
import com.game.demo.dto.request.JoinGameRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface StartService {

    ResponseEntity<?> initGame(CreateGameRequest createGameRequest);
    ResponseEntity<?> joinGame (JoinGameRequest joinGameRequest);

}
