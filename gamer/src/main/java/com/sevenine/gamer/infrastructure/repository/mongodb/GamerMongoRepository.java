package com.sevenine.gamer.infrastructure.repository.mongodb;

import com.sevenine.gamer.infrastructure.repository.document.GamerDocument;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface GamerMongoRepository extends MongoRepository<GamerDocument, String> {
    Optional<GamerDocument> findByUuidUser(String uuid);

    Optional<GamerDocument> findByUuid(String uuid);
}
