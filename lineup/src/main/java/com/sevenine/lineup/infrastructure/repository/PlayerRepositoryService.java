package com.sevenine.lineup.infrastructure.repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sevenine.lineup.application.service.PlayerRepository;
import com.sevenine.lineup.business.entity.Player;
import com.sevenine.lineup.business.enumerated.PositionEnum;
import com.sevenine.lineup.infrastructure.repository.document.PlayerDocument;
import com.sevenine.lineup.infrastructure.repository.mongodb.PlayerMongoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class PlayerRepositoryService implements PlayerRepository {

    private final PlayerMongoRepository repository;
    private final ObjectMapper mapper;

    @Override
    public Page<Player> list(Pageable pageable) {
        return convert(repository.findByPositionIsNotNull(pageable));
    }

    @Override
    public Page<Player> list(Pageable pageable, PositionEnum position) {
        return convert(repository.findByPosition(position.getAcronym(), pageable));
    }

    private Page<Player> convert(Page<PlayerDocument> documents) {
        List<Player> players = documents.stream().map(document -> mapper.convertValue(document, Player.class))
                .collect(Collectors.toList());

        return new PageImpl<>(players, documents.getPageable(), documents.getTotalElements());
    }

}
