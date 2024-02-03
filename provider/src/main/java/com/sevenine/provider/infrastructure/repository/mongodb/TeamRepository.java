package com.sevenine.provider.infrastructure.repository.mongodb;

import com.sevenine.provider.infrastructure.repository.document.TeamDocument;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeamRepository extends MongoRepository<TeamDocument, String> {
}
