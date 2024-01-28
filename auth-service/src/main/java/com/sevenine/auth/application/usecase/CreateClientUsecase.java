package com.sevenine.auth.client.application.usecase;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sevenine.auth.client.application.service.LeagueService;
import com.sevenine.auth.client.application.usecase.output.CreateClientOutput;
import com.sevenine.auth.client.business.Client;
import com.sevenine.auth.client.application.usecase.input.CreateClientInput;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class CreateClientUsecase {

    private final LeagueService leagueService;

    private final ObjectMapper mapper;

    public CreateClientOutput create(CreateClientInput input) {
        Client client = mapper.convertValue(input, Client.class).generatedUuid();

        Client response = leagueService.create(client);

        return new CreateClientOutput(response.getUuid(), "OK");
    }

}
