package com.sevenine.game.infrastructure.repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sevenine.game.application.service.GamerRepository;
import com.sevenine.game.business.entity.Gamer;
import com.sevenine.game.infrastructure.exception.GameNotFoundException;
import com.sevenine.game.infrastructure.exception.GameUnprocessableEntityException;
import com.sevenine.game.infrastructure.repository.document.GamerDocument;
import com.sevenine.game.infrastructure.repository.mongodb.GamerMongoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import static java.lang.String.format;
import static java.util.Objects.isNull;

@RequiredArgsConstructor
@Service
public class GamerRepositoryService implements GamerRepository {

    private final GamerMongoRepository repository;
    private final ObjectMapper mapper;

    @Override
    public Gamer save(Gamer newGamer) {
        try {
            Gamer gamer = findByUuidUser(newGamer.getUuidUser());
            if (!isNull(gamer.getUuid())) {
                throw new GameUnprocessableEntityException(format("Jogador já possui cadastro: %s!", gamer.getUuid()));
            }
        } catch (GameNotFoundException e) {
            GamerDocument gamerDocument = mapper.convertValue(newGamer, GamerDocument.class);
            newGamer = mapper.convertValue(repository.save(gamerDocument), Gamer.class);
        }
        return newGamer;
    }

    @Override
    public Gamer findByUuid(String uuid) {
        return mapper.convertValue(repository.findByUuid(uuid).orElseThrow(() ->
                new GameNotFoundException(format("Jogador %s não possui cadastro", uuid))), Gamer.class);
    }

    @Override
    public Gamer findByUuidUser(String uuidUser) {
        return mapper.convertValue(repository.findByUuidUser(uuidUser).orElseThrow(() ->
                new GameNotFoundException(format("Usuário %s não possui cadastro", uuidUser))), Gamer.class);
    }

}
