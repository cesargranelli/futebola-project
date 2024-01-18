package com.sevenine.america.infrastructure.aws.documentdb.document;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Document("leagues")
public class LeagueDocument {
    @Id
    private String id;
    private String name;
    private String nick;
    private String city;
}
