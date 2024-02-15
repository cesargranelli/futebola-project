package com.sevenine.game.infrastructure.rest;

import com.sevenine.game.application.usecase.CreateGamer;
import com.sevenine.game.application.usecase.FindGamer;
import com.sevenine.game.application.usecase.FindGamerByUser;
import com.sevenine.game.application.usecase.input.CreateGamerInput;
import com.sevenine.game.application.usecase.output.GamerOutput;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RequestMapping(value = "gamers", produces = MediaType.APPLICATION_JSON_VALUE)
@RestController
public class GamerRest {

    private final CreateGamer createGamer;
    private final FindGamer findGamer;
    private final FindGamerByUser findGamerByUser;

    @PostMapping
    public ResponseEntity<GamerOutput> create(@RequestBody CreateGamerInput input) {
        return ResponseEntity.status(HttpStatus.CREATED).body(createGamer.execute(input));
    }

    @GetMapping("uuid")
    public ResponseEntity<GamerOutput> find(@RequestParam("uuid") String uuid) {
        return ResponseEntity.status(HttpStatus.OK).body(findGamer.execute(uuid));
    }

    @GetMapping("uuid-user")
    public ResponseEntity<GamerOutput> findByUser(@RequestParam("uuid-user") String uuidUser) {
        return ResponseEntity.status(HttpStatus.OK).body(findGamerByUser.execute(uuidUser));
    }

}
