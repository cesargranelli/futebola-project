package com.sevenine.lineup.infrastructure.repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sevenine.lineup.application.service.LineupRepository;
import com.sevenine.lineup.business.entity.Lineup;
import com.sevenine.lineup.infrastructure.repository.document.LineupDocument;
import com.sevenine.lineup.infrastructure.repository.mongodb.LineupMongoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

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
        return mapper.convertValue(newLineup, LineupDocument.class);
    }

}
