package com.sevenine.auth.client.infrastructure.rest;

import com.sevenine.auth.client.application.usecase.CreateClientUsecase;
import com.sevenine.auth.client.application.usecase.input.CreateClientInput;
import com.sevenine.auth.client.application.usecase.output.CreateClientOutput;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RequestMapping(value = "clients", consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE)
@RestController
public class ClientRest {

    private final CreateClientUsecase createClientUsecase;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public ResponseEntity<CreateClientOutput> clients(@RequestBody CreateClientInput input) {
        return ResponseEntity.status(HttpStatus.CREATED).body(createClientUsecase.create(input));
    }

}
