package com.sevenine.game;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@EnableMongoRepositories
@SpringBootApplication
public class GamerApplication {

    public static void main(String[] args) {
        SpringApplication.run(GamerApplication.class, args);
    }

}
