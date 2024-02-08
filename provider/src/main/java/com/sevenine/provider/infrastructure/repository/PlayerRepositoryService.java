package com.sevenine.provider.infrastructure.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sevenine.provider.application.service.PlayerRepository;
import com.sevenine.provider.business.entity.Player;
import com.sevenine.provider.infrastructure.repository.document.PlayerDocument;
import com.sevenine.provider.infrastructure.repository.mongodb.PlayerMongoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@RequiredArgsConstructor
@Component
public class PlayerRepositoryService implements PlayerRepository {

    private final PlayerMongoRepository repository;
    private final ObjectMapper mapper;

    @Override
    public Player findByIdOrigin(Long idOrigin) {
        return repository.findByIdOrigin(idOrigin).map(playerDocument ->
                mapper.convertValue(playerDocument, Player.class)).orElse(null);
    }

    @Override
    public void save(List<Player> players) {
        repository.saveAll(mapper.convertValue(players, new TypeReference<Iterable<? extends PlayerDocument>>() {
        }));
    }

}
