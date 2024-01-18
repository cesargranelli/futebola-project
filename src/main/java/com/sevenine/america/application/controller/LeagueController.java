package com.sevenine.america.application.controller;

import com.sevenine.america.application.controller.request.CreateLeagueRequest;
import com.sevenine.america.application.controller.response.CreateLeagueResponse;
import com.sevenine.america.application.usecase.LeagueUsecase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping(value = "leagues", consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE)
@RestController
public class LeagueController {

    private final LeagueUsecase leagueUsecase;

    @Autowired
    public LeagueController(LeagueUsecase leagueUsecase) {
        this.leagueUsecase = leagueUsecase;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public ResponseEntity<CreateLeagueResponse> leagues(@RequestBody CreateLeagueRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(leagueUsecase.create(request));
    }

}
