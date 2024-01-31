package com.sevenine.player.infrastructure.rest;

import com.sevenine.player.application.usecase.PlayerUsecase;
import com.sevenine.player.application.usecase.output.PlayerOutput;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping(value = "players")
@RestController
public class PlayerRest {

    private final PlayerUsecase playerUsecase;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    public ResponseEntity<List<PlayerOutput>> players() {
        return ResponseEntity.status(HttpStatus.OK).body(playerUsecase.list());
    }

}
