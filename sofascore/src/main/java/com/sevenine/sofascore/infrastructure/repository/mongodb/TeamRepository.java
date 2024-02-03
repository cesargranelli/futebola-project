package com.sevenine.sofascore.infrastructure.repository.mongodb;

import com.sevenine.sofascore.infrastructure.repository.document.TeamDocument;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeamRepository extends MongoRepository<TeamDocument, String> {
}
