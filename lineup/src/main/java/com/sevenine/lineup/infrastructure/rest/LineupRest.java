package com.sevenine.lineup.infrastructure.rest;

import com.sevenine.lineup.application.usecase.LineupSave;
import com.sevenine.lineup.application.usecase.input.LineupInput;
import com.sevenine.lineup.application.usecase.output.LineupOutput;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RequestMapping(value = "lineups", produces = MediaType.APPLICATION_JSON_VALUE)
@RestController
public class LineupRest {

    private final LineupSave lineupSave;

    @ResponseStatus(HttpStatus.OK)
    @PutMapping
    public ResponseEntity<LineupOutput> lineups(@RequestBody LineupInput lineup) {
        return ResponseEntity.status(HttpStatus.OK).body(lineupSave.execute(lineup));
    }

}
