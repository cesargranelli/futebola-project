package com.sevenine.player.infrastructure.repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sevenine.player.application.service.PlayerRepository;
import com.sevenine.player.business.entity.Player;
import com.sevenine.player.infrastructure.repository.document.PlayerDocument;
import com.sevenine.player.infrastructure.repository.mongodb.PlayerMongoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class PlayerServiceRepository implements PlayerRepository {

    private final PlayerMongoRepository repository;
    private final ObjectMapper mapper;

    @Override
    public Page<Player> listPlayers(Pageable pageable) {
        Page<PlayerDocument> documents = repository.findByPositionIsNotNull(pageable);

        List<Player> players = documents.stream().map(document -> mapper.convertValue(document, Player.class))
                .collect(Collectors.toList());

        return new PageImpl<>(players, documents.getPageable(), documents.getTotalElements());
    }

}
