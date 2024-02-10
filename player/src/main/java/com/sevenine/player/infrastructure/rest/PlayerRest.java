package com.sevenine.player.infrastructure.rest;

import com.sevenine.player.application.usecase.PlayerUsecase;
import com.sevenine.player.application.usecase.output.PagenateOutput;
import com.sevenine.player.application.usecase.output.PlayerOutput;
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
        Page<PlayerOutput> outputs = playerUsecase.list(PageRequest.of(page, size));
        return ResponseEntity.status(HttpStatus.OK).body(convertPagenate(outputs));
    }

    private PagenateOutput<?> convertPagenate(Page<?> page) {
        return new PagenateOutput<>(page.getContent(), page.getNumber(), page.getSize(), page.getNumberOfElements());
    }

}
