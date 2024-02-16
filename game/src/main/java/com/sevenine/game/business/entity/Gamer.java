package com.sevenine.game.business.entity;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
public class Gamer {
    private String uuid;
    private String uuidUser;
    private String nick;
    private Integer points;
    private Team team;
    private List<League> leagues;
    private BigDecimal totalScore;
    private BigDecimal roundScore;
    private LocalDate createdAt;

    public final Gamer createGamer(String uuidUser, String nick, Integer initialPoints) {
        this.uuid = UUID.randomUUID().toString();
        this.uuidUser = uuidUser;
        this.nick = nick;
        this.points = initialPoints;
        this.createdAt = LocalDate.now();

        return this;
    }
}
