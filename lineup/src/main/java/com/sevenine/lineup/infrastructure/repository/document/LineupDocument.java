package com.sevenine.lineup.infrastructure.repository.document;

import com.sevenine.lineup.business.enumerated.FormationEnum;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Document("lineups")
public class LineupDocument {
    @Id
    private String id;
    private String uuid;
    private GamerDocument gamer;
    @Field(name = "formation_enum")
    private FormationEnum formationEnum;
    @Field(name = "round_number")
    private Integer roundNumber;
    private List<PlayerDocument> players;
    private List<PlayerDocument> reserves;
    @Field(name = "created_at")
    private LocalDateTime createdAt;
}
