package com.sevenine.provider.infrastructure.rest;

import com.sevenine.provider.application.usecase.UpdateTeamUsecase;
import com.sevenine.provider.application.usecase.input.UpdateTeamInput;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RequestMapping(value = "teams")
@RestController
public class ProviderRest {

    private final UpdateTeamUsecase updateTeamUsecase;

    @ResponseStatus(HttpStatus.OK)
    @PutMapping(value = "update")
    public ResponseEntity<Void> update(@RequestBody UpdateTeamInput input) {
        updateTeamUsecase.execute(input);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

}
