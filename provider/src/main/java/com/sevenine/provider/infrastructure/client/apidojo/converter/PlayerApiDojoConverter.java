package com.sevenine.provider.infrastructure.client.apidojo.converter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sevenine.provider.application.service.response.PlayerResponse;
import com.sevenine.provider.infrastructure.client.apidojo.response.SquadApiDojo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@RequiredArgsConstructor
@Component
public class PlayerApiDojoConverter {

    private final List<PlayerResponse> playerResponseList;
    private final ObjectMapper mapper;

    public List<PlayerResponse> convert(SquadApiDojo squadApiDojo) {
        Arrays.stream(squadApiDojo.players()).forEach(player ->
                playerResponseList.add(mapper.convertValue(player.player(), PlayerResponse.class)));

        return playerResponseList;
    }

}
