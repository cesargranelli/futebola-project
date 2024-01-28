package com.sevenine.auth.client.infrastructure.repository.mongodb;

import com.sevenine.auth.client.infrastructure.repository.mongodb.document.ClientDocument;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClientRepository extends MongoRepository<ClientDocument, String> {
    Optional<ClientDocument> findByDocument(String document);
}
