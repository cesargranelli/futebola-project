package com.sevenine.provider.application.usecase;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sevenine.provider.application.service.TeamRepository;
import com.sevenine.provider.application.service.response.TeamResponse;
import com.sevenine.provider.application.strategy.TeamApiContextStrategy;
import com.sevenine.provider.application.usecase.input.UpdateTeamInput;
import com.sevenine.provider.business.entity.Team;
import com.sevenine.provider.business.enumerated.ProviderEnum;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.Objects.isNull;

@RequiredArgsConstructor
@Component
public class UpdateTeamUsecase {

    private final TeamApiContextStrategy strategy;
    private final TeamRepository repository;
    private final ObjectMapper mapper;

    public void execute(UpdateTeamInput input) {
        List<TeamResponse> responses = strategy.withProvider(input.provider())
                .execute(input.tournament().getCode(), input.season().getCode());

        List<Team> teams = responses.stream().map(response -> convertTeam(response, input.provider()))
                .filter(team -> !isNull(team)).collect(Collectors.toList());

        if (!teams.isEmpty()) repository.save(teams);
    }

    private Team convertTeam(TeamResponse response, ProviderEnum provider) {
        return (repository.findByIdOrigin(response.id()) != null) ? null :
                new Team().createTeam(response.id(), response.name(), response.shortName(),
                        response.nameCode(), provider);
    }

}
