package com.sevenine.game.infrastructure.repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sevenine.game.application.service.GamerRepository;
import com.sevenine.game.business.entity.Gamer;
import com.sevenine.game.infrastructure.repository.document.GamerDocument;
import com.sevenine.game.infrastructure.repository.mongodb.GamerMongoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import static java.util.Objects.isNull;

@RequiredArgsConstructor
@Service
public class GamerRepositoryService implements GamerRepository {

    private final GamerMongoRepository repository;
    private final ObjectMapper mapper;

    @Override
    public Gamer save(Gamer newGamer) {
        Gamer gamer = findByUuid(newGamer.getUuid());
        if (isNull(gamer.getUuid())) {
            GamerDocument gamerDocument = mapper.convertValue(newGamer, GamerDocument.class);
            return mapper.convertValue(repository.save(gamerDocument), Gamer.class);
        }
        return mapper.convertValue(gamer, Gamer.class);
    }

    @Override
    public Gamer findByUuid(String uuid) {
        return mapper.convertValue(repository.findByUuid(uuid).orElse(null), Gamer.class);
    }

    @Override
    public Gamer findByUuidUser(String uuidUser) {
        return mapper.convertValue(repository.findByUuidUser(uuidUser).orElse(null), Gamer.class);
    }

}
