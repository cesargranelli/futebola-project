package com.sevenine.lineup.infrastructure.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sevenine.lineup.application.service.LineupRepository;
import com.sevenine.lineup.business.entity.Lineup;
import com.sevenine.lineup.infrastructure.repository.document.GamerDocument;
import com.sevenine.lineup.infrastructure.repository.document.LineupDocument;
import com.sevenine.lineup.infrastructure.repository.mongodb.LineupMongoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class LineupRepositoryService implements LineupRepository {

    private final LineupMongoRepository repository;
    private final ObjectMapper mapper;

    @Override
    public Lineup save(Lineup newLineup) {
        return mapper.convertValue(repository.save(convertNewLineup(newLineup)), Lineup.class);
    }

    private LineupDocument convertNewLineup(Lineup newLineup) {
        LineupDocument document = new LineupDocument();
        document.setUuid(UUID.randomUUID().toString());
        document.setGamer(mapper.convertValue(newLineup.getGamer(), GamerDocument.class));
        document.setFormationEnum(newLineup.getFormationEnum());
        document.setRoundNumber(newLineup.getRoundNumber());
        document.setPlayers(mapper.convertValue(newLineup.getPlayers(), new TypeReference<>() {
        }));
        document.setReserves(mapper.convertValue(newLineup.getReserves(), new TypeReference<>() {
        }));
        document.setCreatedAt(LocalDateTime.now());

        return document;
    }

}
