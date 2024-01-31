package com.sevenine.player.infrastructure.repository.document;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Getter
@Setter
@Document("players")
public class PlayerDocument {
    @Id
    private String id;
    private String uuid;
    @Field(name = "id_origin")
    private String idOrigin;
    private String name;
    @Field(name = "short_name")
    private String shortName;
    private String position;
    @Field(name = "shirt_name")
    private String shirtName;
}
