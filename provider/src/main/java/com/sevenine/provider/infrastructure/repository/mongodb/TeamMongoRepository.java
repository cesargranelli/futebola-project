package com.sevenine.provider.infrastructure.repository.mongodb;

import com.sevenine.provider.infrastructure.repository.document.TeamDocument;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface TeamMongoRepository extends MongoRepository<TeamDocument, String> {
    Optional<TeamDocument> findByIdOrigin(Long slug);
}
