package com.sevenine.provider.infrastructure.config;

import com.sevenine.provider.infrastructure.repository.mongodb.TeamMongoRepository;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@EnableMongoRepositories(basePackageClasses = {
        TeamMongoRepository.class
})
@Configuration
public class MongoDBConfig {
}
