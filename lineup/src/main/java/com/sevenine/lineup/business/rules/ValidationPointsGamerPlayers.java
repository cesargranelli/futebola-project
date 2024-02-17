package com.sevenine.lineup.business.rules;

import com.sevenine.lineup.business.entity.Lineup;
import com.sevenine.lineup.business.rules.lineup.LineupValidationRules;
import com.sevenine.lineup.infrastructure.exception.ValidationLineupException;
import com.sevenine.lineup.infrastructure.properties.LineupErrorProperties;
import com.sevenine.lineup.infrastructure.properties.LineupProperties;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

import static java.lang.String.format;

@ConditionalOnProperty(prefix = "app.rules", name = "validation-points-gamer-players", havingValue = "true")
@RequiredArgsConstructor
@Component
public class ValidationPointsGamerPlayers implements LineupValidationRules {

    private final LineupProperties lineupProperties;
    private final LineupErrorProperties properties;

    @Override
    public void execute(Lineup lineup) {
        if (lineup.getReserves().size() != lineupProperties.getTotalReserves()) {
            throw new ValidationLineupException(format(properties.getNumberReservePlayers(),
                    lineupProperties.getTotalReserves(), lineup.getReserves().size()));
        }
    }

}
