package com.sevenine.player;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@EnableMongoRepositories
@SpringBootApplication
public class PlayerApplication {

    public static void main(String[] args) {
        SpringApplication.run(PlayerApplication.class, args);
    }

}
