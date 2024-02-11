package com.sevenine.lineup;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@EnableMongoRepositories
@SpringBootApplication
public class LineupApplication {

    public static void main(String[] args) {
        SpringApplication.run(LineupApplication.class, args);
    }

}
