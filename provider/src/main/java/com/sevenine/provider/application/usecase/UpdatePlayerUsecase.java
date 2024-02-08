package com.sevenine.provider.application.usecase;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sevenine.provider.application.service.PlayerRepository;
import com.sevenine.provider.application.service.TeamRepository;
import com.sevenine.provider.application.service.response.PlayerResponse;
import com.sevenine.provider.application.strategy.PlayerApiContextStrategy;
import com.sevenine.provider.application.usecase.input.UpdatePlayerInput;
import com.sevenine.provider.business.entity.Player;
import com.sevenine.provider.business.entity.Team;
import com.sevenine.provider.business.enumerated.ProviderEnum;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.Objects.isNull;

@RequiredArgsConstructor
@Component
public class UpdatePlayerUsecase {

    private final PlayerApiContextStrategy strategy;
    private final TeamRepository teamRepository;
    private final PlayerRepository repository;
    private final ObjectMapper mapper;

    public void execute(UpdatePlayerInput input) {
        List<Team> teams = teamRepository.findAll();

        List<PlayerResponse> responses = teams.stream().map(team -> strategy.withProvider(input.provider())
                .execute(team.getIdOrigin())).toList().get(0);

        List<Player> players = responses.stream().map(response -> getPlayer(response, input.provider()))
                .filter(player -> !isNull(player)).collect(Collectors.toList());

        if (!players.isEmpty()) repository.save(players);
    }

    private Player getPlayer(PlayerResponse response, ProviderEnum provider) {
        return (repository.findByIdOrigin(response.id()) != null) ? null :
                new Player().createPlayer(response.id(), response.name(), response.shortName(), response.position(),
                        response.shirtNumber(), provider, mapper.convertValue(response.team(), Team.class));
    }

}
