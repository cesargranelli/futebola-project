package com.sevenine.provider.infrastructure.rest;

import com.sevenine.provider.application.usecase.UpdatePlayerUsecase;
import com.sevenine.provider.application.usecase.UpdateTeamUsecase;
import com.sevenine.provider.application.usecase.input.UpdatePlayerInput;
import com.sevenine.provider.application.usecase.input.UpdateTeamInput;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class ProviderRest {

    private final UpdateTeamUsecase updateTeamUsecase;
    private final UpdatePlayerUsecase updatePlayerUsecase;

    @ResponseStatus(HttpStatus.OK)
    @PutMapping("teams")
    public ResponseEntity<Void> teams(@RequestBody UpdateTeamInput input) {
        updateTeamUsecase.execute(input);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping("players")
    public ResponseEntity<Void> players(@RequestBody UpdatePlayerInput input) {
        updatePlayerUsecase.execute(input);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

}
