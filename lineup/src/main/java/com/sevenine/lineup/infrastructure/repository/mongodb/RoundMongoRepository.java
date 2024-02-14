package com.sevenine.lineup.infrastructure.repository.mongodb;

import com.sevenine.lineup.business.enumerated.StatusRoundEnum;
import com.sevenine.lineup.infrastructure.repository.document.RoundDocument;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoundMongoRepository extends MongoRepository<RoundDocument, String> {
    List<RoundDocument> findByStatus(StatusRoundEnum status);
}
