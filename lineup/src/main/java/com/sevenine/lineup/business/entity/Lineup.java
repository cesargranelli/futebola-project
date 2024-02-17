package com.sevenine.lineup.business.entity;

import com.sevenine.lineup.business.enumerated.FormationEnum;
import com.sevenine.lineup.business.rules.lineup.LineupValidationRules;
import com.sevenine.lineup.infrastructure.exception.FormationException;
import lombok.Getter;
import lombok.Setter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

import static java.lang.String.format;

@Getter
@Setter
public class Lineup {
    private final Logger logger = LoggerFactory.getLogger(Lineup.class);

    private String uuid;
    private Gamer gamer;
    private FormationEnum formationEnum;
    private Integer roundNumber;
    private List<Player> players;
    private List<Player> reserves;

    public void executeRules(List<LineupValidationRules> rules) {
        rules.forEach(rule -> rule.execute(this));
    }

    public void logAndThrow(String message, Object... values) {
        logger.error(message.replaceAll("%s", "{}"), values);

        throw new FormationException(format(message, values));
    }
}
