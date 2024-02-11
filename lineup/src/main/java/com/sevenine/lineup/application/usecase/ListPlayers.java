package com.sevenine.lineup.application.usecase;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sevenine.lineup.application.usecase.output.PlayerOutput;
import com.sevenine.lineup.business.entity.Player;
import com.sevenine.lineup.business.enumerated.PositionNameEnum;
import com.sevenine.lineup.infrastructure.repository.PlayerServiceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.List;

@RequiredArgsConstructor
@Component
public class ListPlayers {

    private final PlayerServiceRepository playerServiceRepository;
    private final ObjectMapper mapper;

    public Page<PlayerOutput> list(Pageable pageable, PositionNameEnum position) {
        if (position.getAcronym().equals(PositionNameEnum.TODAS.getAcronym())) {
            return convert(playerServiceRepository.list(pageable));
        } else {
            return convert(playerServiceRepository.list(pageable, position));
        }
    }

    private Page<PlayerOutput> convert(Page<Player> players) {
        List<PlayerOutput> outputs = players.stream().map(player ->
                mapper.convertValue(player, PlayerOutput.class)).toList();

        return new PageImpl<>(outputs, players.getPageable(), players.getTotalElements());
    }

}
