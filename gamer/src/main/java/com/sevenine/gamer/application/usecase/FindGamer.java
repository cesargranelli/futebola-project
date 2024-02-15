package com.sevenine.gamer.application.usecase;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sevenine.gamer.application.service.GamerRepository;
import com.sevenine.gamer.application.usecase.output.GamerOutput;
import com.sevenine.gamer.business.entity.Gamer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class FindGamer {

    private final GamerRepository repository;
    private final ObjectMapper mapper;

    public GamerOutput execute(String uuid) {
        Gamer gamer = repository.findByUuid(uuid);

        return mapper.convertValue(gamer, GamerOutput.class);
    }

}
