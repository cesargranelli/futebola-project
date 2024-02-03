package com.sevenine.sofascore.application.usecase;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sevenine.sofascore.application.service.TeamApiService;
import com.sevenine.sofascore.application.service.response.TeamResponse;
import com.sevenine.sofascore.application.usecase.input.UpdateTeamInput;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@RequiredArgsConstructor
@Component
public class UpdateTeamUsecase {

    private final TeamApiService teamApiService;

    private final ObjectMapper mapper;

    public void execute(UpdateTeamInput input) {
        List<TeamResponse> response =
                teamApiService.list(input.tournament().getCode(), input.season().getCode());

        System.out.println(response);
    }

}
