package com.sevenine.client.application.usecase;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sevenine.client.application.service.LeagueService;
import com.sevenine.client.application.usecase.input.CreateClientInput;
import com.sevenine.client.application.usecase.output.CreateClientOutput;
import com.sevenine.client.business.Client;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class CreateClientUsecase {

    private final LeagueService leagueService;

    private final ObjectMapper mapper;

    public CreateClientOutput create(CreateClientInput request) {
        Client client = mapper.convertValue(request, Client.class);

        Client response = leagueService.create(client);

        return new CreateClientOutput(response.getUuid(), "OK");
    }

}
