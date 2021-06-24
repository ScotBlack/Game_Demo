package com.game.demo.service;

import com.game.demo.dto.CreatePlayerRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface PlayerService {

    ResponseEntity<?> createPlayer(CreatePlayerRequest createPlayerRequest);
}
