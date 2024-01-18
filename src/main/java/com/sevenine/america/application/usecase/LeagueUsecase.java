package com.sevenine.america.application.usecase;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sevenine.america.application.controller.request.CreateLeagueRequest;
import com.sevenine.america.application.controller.response.CreateLeagueResponse;
import com.sevenine.america.application.service.LeagueService;
import com.sevenine.america.infrastructure.aws.documentdb.document.LeagueDocument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LeagueUsecase {

    private final LeagueService leagueService;

    private final ObjectMapper objectMapper;

    @Autowired
    public LeagueUsecase(LeagueService leagueService, ObjectMapper objectMapper) {
        this.leagueService = leagueService;
        this.objectMapper = objectMapper;
    }

    public CreateLeagueResponse create(CreateLeagueRequest request) {
        LeagueDocument leagueDocument = objectMapper.convertValue(request, LeagueDocument.class);

        LeagueDocument response = leagueService.create(leagueDocument);

        return new CreateLeagueResponse(response.getId().toString(), "OK");
    }

}
