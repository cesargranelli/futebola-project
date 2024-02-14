package com.sevenine.lineup.business.rules;

import com.sevenine.lineup.application.service.RoundRepository;
import com.sevenine.lineup.business.entity.Lineup;
import com.sevenine.lineup.business.enumerated.StatusRoundEnum;
import com.sevenine.lineup.business.rules.lineup.LineupValidationRules;
import com.sevenine.lineup.infrastructure.properties.ValidationLineupProperties;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@RequiredArgsConstructor
@Component
public class ValidationRound implements LineupValidationRules {

    private final static DateTimeFormatter DATETIMEFORMAT = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    private final ValidationLineupProperties properties;
    private final RoundRepository repository;

    @Override
    public void execute(Lineup lineup) {
        repository.findByStatus(StatusRoundEnum.OPEN).stream()
                .filter(round -> round.getNumber().equals(lineup.getRoundNumber()))
                .forEach(round -> {
                    LocalDateTime begin = LocalDateTime.parse(round.getBeginDateTime(), DATETIMEFORMAT);
                    LocalDateTime end = LocalDateTime.parse(round.getEndDateTime(), DATETIMEFORMAT);
                    LocalDateTime now = LocalDateTime.now();

                    if ((now.isAfter(begin) && now.isBefore(end)) || (now.isAfter(end))) {
                        lineup.logAndThrow(properties.getRound(), begin.format(DATETIMEFORMAT),
                                end.format(DATETIMEFORMAT), now.format(DATETIMEFORMAT));
                    }
                });
    }

}
