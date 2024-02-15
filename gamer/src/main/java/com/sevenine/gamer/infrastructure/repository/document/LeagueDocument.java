package com.sevenine.gamer.infrastructure.repository.document;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Field;

@Getter
@Setter
public class LeagueDocument {
    private String name;
    @Field("entry_date")
    private String entryDate;
}
