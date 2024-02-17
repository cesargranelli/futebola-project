package com.sevenine.lineup.infrastructure.repository.document;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Field;

@Getter
@Setter
public class GamerDocument {
    private String uuid;
    @Field(name = "uuid_user")
    private String uuidUser;
    private String nick;
    private Integer points;
}
