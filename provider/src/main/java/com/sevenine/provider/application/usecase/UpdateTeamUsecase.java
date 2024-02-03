package com.sevenine.provider.application.usecase;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sevenine.provider.application.service.response.TeamResponse;
import com.sevenine.provider.application.strategy.TeamApiContextStrategy;
import com.sevenine.provider.application.usecase.input.UpdateTeamInput;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@RequiredArgsConstructor
@Component
public class UpdateTeamUsecase {

    private final TeamApiContextStrategy strategy;

    private final ObjectMapper mapper;

    public void execute(UpdateTeamInput input) {
        List<TeamResponse> response =
                strategy.withProvider(input.provider()).execute(input.tournament().getCode(), input.season().getCode());

        System.out.println(response);
    }

}
