package com.sevenine.player.infrastructure.repository.mongodb;

import com.sevenine.player.infrastructure.repository.document.PlayerDocument;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayerMongoRepository extends MongoRepository<PlayerDocument, String> {
    Page<PlayerDocument> findByPositionIsNotNull(Pageable pageable);

    Page<PlayerDocument> findByPosition(String position, Pageable pageable);
}
