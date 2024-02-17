package com.sevenine.lineup.infrastructure.repository.document;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Field;

@Getter
@Setter
public class PlayerDocument {
    private String uuid;
    private String name;
    @Field(name = "short_name")
    private String shortName;
    private String position;
    @Field(name = "shirt_number")
    private String shirtNumber;
    private PointDocument points;
}
