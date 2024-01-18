package com.sevenine.america.infrastructure.aws.documentdb.repository;

import com.sevenine.america.infrastructure.aws.documentdb.document.LeagueDocument;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LeagueRepository extends MongoRepository<LeagueDocument, String> {
    Optional<LeagueDocument> findByName(String name);
}
