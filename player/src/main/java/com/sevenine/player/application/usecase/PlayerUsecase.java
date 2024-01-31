package com.sevenine.player.application.usecase;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sevenine.player.application.service.PlayerService;
import com.sevenine.player.application.usecase.output.PlayerOutput;
import com.sevenine.player.entity.Player;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Component
public class PlayerUsecase {

    private final PlayerService playerService;

    private final ObjectMapper mapper;

    public List<PlayerOutput> list() {
        List<Player> players = playerService.listPlayers();

        return players.stream().map(player -> mapper.convertValue(player, PlayerOutput.class))
                .collect(Collectors.toList());
    }

}
