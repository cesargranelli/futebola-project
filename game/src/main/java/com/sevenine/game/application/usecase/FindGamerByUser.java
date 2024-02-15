package com.sevenine.game.application.usecase;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sevenine.game.application.service.GamerRepository;
import com.sevenine.game.application.usecase.output.GamerOutput;
import com.sevenine.game.business.entity.Gamer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class FindGamerByUser {

    private final GamerRepository repository;
    private final ObjectMapper mapper;

    public GamerOutput execute(String uuidUser) {
        Gamer gamer = repository.findByUuidUser(uuidUser);

        return mapper.convertValue(gamer, GamerOutput.class);
    }

}
