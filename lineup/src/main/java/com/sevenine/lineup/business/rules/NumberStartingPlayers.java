package com.sevenine.lineup.business.rules;

import com.sevenine.lineup.business.entity.Lineup;
import com.sevenine.lineup.business.rules.lineup.LineupValidationRules;
import com.sevenine.lineup.infrastructure.properties.LineupProperties;
import com.sevenine.lineup.infrastructure.properties.LineupErrorProperties;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class NumberStartingPlayers implements LineupValidationRules {

    private final LineupProperties lineupProperties;
    private final LineupErrorProperties properties;

    @Override
    public void execute(Lineup lineup) {
        if (lineup.getPlayers().size() != lineupProperties.getTotalPlayers()) {
            lineup.logAndThrow(properties.getNumberStartingPlayers(), lineupProperties.getTotalPlayers(),
                    lineup.getPlayers().size());
        }
    }

}
