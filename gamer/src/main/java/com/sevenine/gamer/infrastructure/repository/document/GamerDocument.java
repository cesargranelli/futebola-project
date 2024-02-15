package com.sevenine.gamer.infrastructure.repository.document;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@Document("gamers")
public class GamerDocument {
    @Id
    private String id;
    private String uuid;
    @Field("uuid_user")
    private String uuidUser;
    private String nick;
    private Integer points;
    private TeamDocument team;
    private List<LeagueDocument> leagues;
    @Field("total_score")
    private BigDecimal totalScore;
    @Field("round_score")
    private BigDecimal roundScore;
    @Field("create_at")
    private String createAt;
}
