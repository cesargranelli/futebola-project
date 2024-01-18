package com.sevenine.america.application.service;

import com.sevenine.america.infrastructure.aws.documentdb.document.LeagueDocument;
import com.sevenine.america.infrastructure.aws.documentdb.repository.LeagueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static java.util.Objects.isNull;

@Service
public class LeagueService {

    private final LeagueRepository repository;

    @Autowired
    public LeagueService(LeagueRepository repository) {
        this.repository = repository;
    }

    public LeagueDocument create(LeagueDocument leagueDocument) {
        LeagueDocument document = findByName(leagueDocument.getName());
        if (isNull(document)) {
            return repository.save(leagueDocument);
        }
        return document;
    }

    public LeagueDocument findByName(String name) {
        return repository.findByName(name).orElse(null);
    }

}
