package com.sevenine.provider.infrastructure.repository.mongodb;

import com.sevenine.provider.infrastructure.repository.document.PlayerDocument;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface PlayerMongoRepository extends MongoRepository<PlayerDocument, String> {
    Optional<PlayerDocument> findByIdOrigin(Long idOrigin);
}
