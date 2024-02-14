package com.sevenine.lineup.business.rules;

import com.sevenine.lineup.business.entity.Lineup;
import com.sevenine.lineup.infrastructure.properties.ValidationLineupProperties;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class NumberStartingPlayers {

    private final ValidationLineupProperties properties;

    public void execute(Lineup lineup) {
        if (lineup.getPlayers().size() != lineup.getTotalPlayers()) {
            lineup.logAndThrow(properties.getNumberStartingPlayers(), lineup.getTotalPlayers(),
                    lineup.getPlayers().size());
        }
    }

}
