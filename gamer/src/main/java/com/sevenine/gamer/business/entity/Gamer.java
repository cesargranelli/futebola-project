package com.sevenine.gamer.business.entity;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

import static java.util.Objects.isNull;

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
    private String createAt;

    public Gamer generatedUuid() {
        this.uuid = (isNull(uuid)) ? UUID.randomUUID().toString() : this.uuid;
        return this;
    }
}
