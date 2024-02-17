package com.sevenine.lineup.infrastructure.client;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sevenine.lineup.application.service.GameClient;
import com.sevenine.lineup.business.entity.Gamer;
import com.sevenine.lineup.infrastructure.client.response.GamerResponse;
import com.sevenine.lineup.infrastructure.exception.NotFoundLineupException;
import com.sevenine.lineup.infrastructure.properties.LineupClientProperties;
import com.sevenine.lineup.infrastructure.properties.LineupErrorProperties;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

@RequiredArgsConstructor
@Component
public class GameClientService implements GameClient {

    private final RestTemplate restTemplate;
    private final LineupClientProperties clientProperties;
    private final LineupErrorProperties errorProperties;
    private final ObjectMapper mapper;

    @Override
    public Gamer findGamerByUser(String uuidUser) {
        try {
            ResponseEntity<GamerResponse> response =
                    restTemplate.exchange(clientProperties.getGameUuidUser(), HttpMethod.GET, null,
                            GamerResponse.class, uuidUser);

            return mapper.convertValue(response.getBody(), Gamer.class);
        } catch (HttpClientErrorException.NotFound e) {
            throw new NotFoundLineupException(errorProperties.getNotFoundGamer());
        }

    }

}
