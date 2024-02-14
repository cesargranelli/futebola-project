package com.sevenine.lineup.business.rules;

import com.sevenine.lineup.business.entity.Lineup;
import com.sevenine.lineup.infrastructure.properties.ValidationLineupProperties;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class NumberReservePlayers {

    private final ValidationLineupProperties properties;

    public void execute(Lineup lineup) {
        if (lineup.getReserves().size() != lineup.getTotalReserves()) {
            lineup.logAndThrow(properties.getNumberReservePlayers(), lineup.getTotalReserves(),
                    lineup.getReserves().size());
        }
    }

}