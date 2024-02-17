package com.sevenine.lineup.business.rules;

import com.sevenine.lineup.business.entity.Lineup;
import com.sevenine.lineup.business.rules.lineup.LineupValidationRules;
import com.sevenine.lineup.infrastructure.exception.ValidationLineupException;
import com.sevenine.lineup.infrastructure.properties.LineupErrorProperties;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

import java.util.Arrays;

import static java.lang.String.format;

@ConditionalOnProperty(prefix = "app.rules", name = "validation-formation", havingValue = "true")
@RequiredArgsConstructor
@Component
public class ValidationFormation implements LineupValidationRules {

    private Lineup lineup;
    private final LineupErrorProperties properties;

    @Override
    public void execute(Lineup lineup) {
        this.lineup = lineup;

        Arrays.stream(lineup.getFormationEnum().getAcronym().split("-")).forEach(formation -> {
            if (quantityPlayersPosition(formation.substring(0, 1)) != quantityFormation(formation.substring(1, 2))) {
                throw new ValidationLineupException(format(properties.getFormation(), formation,
                        quantityPlayersPosition(formation.substring(0, 1))));
            }
        });
    }

    private int quantityPlayersPosition(String position) {
        return lineup.getPlayers().stream().filter(player ->
                player.getPosition().getAcronym().equals(position)).toList().size();
    }

    private int quantityFormation(String position) {
        return Integer.parseInt(position);
    }

}
