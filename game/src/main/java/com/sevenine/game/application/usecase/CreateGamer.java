package com.sevenine.game.application.usecase;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sevenine.game.application.properties.GameProperties;
import com.sevenine.game.application.service.GamerRepository;
import com.sevenine.game.application.usecase.input.CreateGamerInput;
import com.sevenine.game.application.usecase.output.GamerOutput;
import com.sevenine.game.business.entity.Gamer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class CreateGamer {

    private final GamerRepository repository;
    private final ObjectMapper mapper;
    private final GameProperties properties;

    public GamerOutput execute(CreateGamerInput input) {
        Gamer newGamer = new Gamer().createGamer(input.uuidUser(), input.nick(), properties.getInitialPoints());

        Gamer gamer = repository.save(newGamer);

        return mapper.convertValue(gamer, GamerOutput.class);
    }

}
