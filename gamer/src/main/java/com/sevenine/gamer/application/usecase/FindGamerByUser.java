package com.sevenine.gamer.application.usecase;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sevenine.gamer.application.service.GamerRepository;
import com.sevenine.gamer.application.usecase.output.GamerOutput;
import com.sevenine.gamer.business.entity.Gamer;
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
