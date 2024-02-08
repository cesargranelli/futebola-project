package com.sevenine.auth.infrastructure.repository.mongodb;

import com.sevenine.auth.infrastructure.repository.document.UserDocument;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClientRepository extends MongoRepository<UserDocument, String> {
    Optional<UserDocument> findByCredentialsUsername(String username);
}
