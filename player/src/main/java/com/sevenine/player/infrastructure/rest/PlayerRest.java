package com.sevenine.player.infrastructure.rest;

import com.sevenine.player.application.usecase.PlayerUsecase;
import com.sevenine.player.application.usecase.output.PagenateOutput;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RequestMapping(value = "players", produces = MediaType.APPLICATION_JSON_VALUE)
@RestController
public class PlayerRest {

    private final PlayerUsecase playerUsecase;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    public ResponseEntity<PagenateOutput<?>> players(@RequestParam("page") int page, @RequestParam("size") int size) {
        return convertPagenate(playerUsecase.list(PageRequest.of(page - 1, size)), HttpStatus.OK);
    }

    private ResponseEntity<PagenateOutput<?>> convertPagenate(Page<?> page, HttpStatus status) {
        PagenateOutput<Object> output = new PagenateOutput<>(page.getContent(), page.getNumber() + 1, page.getNumberOfElements(), page.getTotalPages());
        return ResponseEntity.status(status).body(output);
    }

}
