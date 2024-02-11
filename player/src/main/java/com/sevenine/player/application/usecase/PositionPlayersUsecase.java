package com.sevenine.player.application.usecase;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sevenine.player.application.usecase.output.PlayerOutput;
import com.sevenine.player.business.entity.Player;
import com.sevenine.player.business.enumerated.PositionNameEnum;
import com.sevenine.player.infrastructure.repository.PlayerServiceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.List;

@RequiredArgsConstructor
@Component
public class PositionPlayersUsecase {

    private final PlayerServiceRepository playerServiceRepository;
    private final ObjectMapper mapper;

    public Page<PlayerOutput> list(Pageable pageable, PositionNameEnum position) {
        Page<Player> players = playerServiceRepository.listAllPlayersByPosition(pageable, position);

        List<PlayerOutput> outputs = players.stream().map(player ->
                mapper.convertValue(player, PlayerOutput.class)).toList();

        return new PageImpl<>(outputs, players.getPageable(), players.getTotalElements());
    }

}
