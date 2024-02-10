package com.sevenine.player.infrastructure.repository.mongodb;

import com.sevenine.player.infrastructure.repository.document.PlayerDocument;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayerMongoRepository extends MongoRepository<PlayerDocument, String> {
}
