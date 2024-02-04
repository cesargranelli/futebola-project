package com.sevenine.provider.infrastructure.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sevenine.provider.application.service.TeamRepositoriesService;
import com.sevenine.provider.business.entity.Team;
import com.sevenine.provider.infrastructure.repository.document.TeamDocument;
import com.sevenine.provider.infrastructure.repository.mongodb.TeamMongoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@RequiredArgsConstructor
@Component
public class TeamRepositories implements TeamRepositoriesService {

    private final TeamMongoRepository repository;
    private final ObjectMapper mapper;

    @Override
    public Team findBySlug(String slug) {
        return repository.findBySlug(slug).map(teamDocument ->
                mapper.convertValue(teamDocument, Team.class)).orElse(null);
    }

    @Override
    public void save(List<Team> teams) {
        repository.saveAll(mapper.convertValue(teams, new TypeReference<Iterable<? extends TeamDocument>>() {
        }));
    }

}
