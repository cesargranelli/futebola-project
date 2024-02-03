package com.sevenine.sofascore.infrastructure.client.apidojo.converter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sevenine.sofascore.application.service.response.TeamResponse;
import com.sevenine.sofascore.infrastructure.client.apidojo.response.TotalApiDojo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Component
public class TeamApiDojoConverter {

    private final List<TeamResponse> teamResponseList;

    private final ObjectMapper mapper;

    public List<TeamResponse> convert(TotalApiDojo totalApiDojo) {
        totalApiDojo.standings()
                .forEach(standing -> standing.rows()
                        .forEach(row -> teamResponseList.add(mapper.convertValue(row.team(), TeamResponse.class))));

        return teamResponseList;
    }

}
