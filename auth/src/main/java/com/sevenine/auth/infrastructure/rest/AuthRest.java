package com.sevenine.auth.infrastructure.rest;

import com.sevenine.auth.application.usecase.SignupUsecase;
import com.sevenine.auth.application.usecase.input.SignupInput;
import com.sevenine.auth.application.usecase.output.SignupOutput;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RequestMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE)
@RestController
public class AuthRest {

    private final SignupUsecase signupUsecase;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(value = "signup")
    public ResponseEntity<SignupOutput> signup(@RequestBody SignupInput input) {
        return ResponseEntity.status(HttpStatus.CREATED).body(signupUsecase.create(input));
    }

}
