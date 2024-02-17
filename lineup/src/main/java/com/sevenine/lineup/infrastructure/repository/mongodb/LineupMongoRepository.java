package com.sevenine.lineup.infrastructure.repository.mongodb;

import com.sevenine.lineup.infrastructure.repository.document.LineupDocument;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LineupMongoRepository extends MongoRepository<LineupDocument, String> {
}
