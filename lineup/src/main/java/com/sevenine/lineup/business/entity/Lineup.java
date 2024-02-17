package com.sevenine.lineup.business.entity;

import com.sevenine.lineup.business.enumerated.FormationEnum;
import com.sevenine.lineup.business.rules.lineup.LineupValidationRules;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
public class Lineup {
    private String uuid;
    private Gamer gamer;
    private FormationEnum formationEnum;
    private Integer roundNumber;
    private List<Player> players;
    private List<Player> reserves;
    private LocalDateTime createdAt;

    public void executeRules(List<LineupValidationRules> rules) {
        rules.forEach(rule -> rule.execute(this));
    }
}
