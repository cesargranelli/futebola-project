package com.sevenine.client.infrastructure.mongodb.repository;

import com.sevenine.client.infrastructure.mongodb.document.ClientDocument;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LeagueRepository extends MongoRepository<ClientDocument, String> {
    Optional<ClientDocument> findByDocument(String name);
}
