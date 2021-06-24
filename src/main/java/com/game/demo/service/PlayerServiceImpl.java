package com.game.demo.service;

import com.game.demo.dto.CreatePlayerRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class PlayerServiceImpl implements PlayerService{

    @Override
    public ResponseEntity<?> createPlayer (CreatePlayerRequest createPlayerRequest) {

        return ResponseEntity.ok(createPlayerRequest.getUsername());
    }
}
