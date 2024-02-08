package com.sevenine.provider.infrastructure.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sevenine.provider.application.service.TeamRepository;
import com.sevenine.provider.business.entity.Team;
import com.sevenine.provider.infrastructure.repository.document.TeamDocument;
import com.sevenine.provider.infrastructure.repository.mongodb.TeamMongoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@RequiredArgsConstructor
@Component
public class TeamRepositoryService implements TeamRepository {

    private final TeamMongoRepository repository;
    private final ObjectMapper mapper;

    @Override
    public Team findByIdOrigin(Long idOrigin) {
        return repository.findByIdOrigin(idOrigin).map(teamDocument ->
                mapper.convertValue(teamDocument, Team.class)).orElse(null);
    }

    @Override
    public void save(List<Team> teams) {
        repository.saveAll(mapper.convertValue(teams, new TypeReference<Iterable<? extends TeamDocument>>() {
        }));
    }

    @Override
    public List<Team> findAll() {
        return mapper.convertValue(repository.findAll(), new TypeReference<>() {
        });
    }

}
