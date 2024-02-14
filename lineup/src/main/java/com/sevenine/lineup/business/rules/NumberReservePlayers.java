package com.sevenine.lineup.business.rules;

import com.sevenine.lineup.business.entity.Lineup;
import com.sevenine.lineup.business.rules.lineup.LineupValidationRules;
import com.sevenine.lineup.infrastructure.properties.LineupProperties;
import com.sevenine.lineup.infrastructure.properties.ValidationLineupProperties;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class NumberReservePlayers implements LineupValidationRules {

    private final LineupProperties lineupProperties;
    private final ValidationLineupProperties properties;

    @Override
    public void execute(Lineup lineup) {
        if (lineup.getReserves().size() != lineupProperties.getTotalReserves()) {
            lineup.logAndThrow(properties.getNumberReservePlayers(), lineupProperties.getTotalReserves(),
                    lineup.getReserves().size());
        }
    }

}
