package com.sevenine.lineup.infrastructure.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sevenine.lineup.application.service.RoundRepository;
import com.sevenine.lineup.business.entity.Round;
import com.sevenine.lineup.business.enumerated.StatusRoundEnum;
import com.sevenine.lineup.infrastructure.repository.mongodb.RoundMongoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@RequiredArgsConstructor
@Component
public class RoundRepositoryService implements RoundRepository {

    private final RoundMongoRepository repository;
    private final ObjectMapper mapper;

    @Override
    public List<Round> findByStatus(StatusRoundEnum status) {
        return mapper.convertValue(repository.findByStatus(status), new TypeReference<>() {
        });
    }

}
