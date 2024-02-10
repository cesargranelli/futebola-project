package com.sevenine.player.application.usecase;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sevenine.player.application.usecase.output.PlayerOutput;
import com.sevenine.player.business.entity.Player;
import com.sevenine.player.infrastructure.repository.PlayerServiceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.data.web.PagedResourcesAssemblerArgumentResolver;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Component
public class PlayerUsecase {

    private final PlayerServiceRepository playerServiceRepository;
    private final ObjectMapper mapper;

    public Page<PlayerOutput> list(Pageable pageable) {
        Page<Player> players = playerServiceRepository.listPlayers(pageable);

        List<PlayerOutput> outputs = players.stream().map(player ->
                mapper.convertValue(player, PlayerOutput.class)).collect(Collectors.toList());

        return new PageImpl<>(outputs);
    }

}
