package com.sevenine.lineup.business.rules;

import com.sevenine.lineup.business.entity.Lineup;
import com.sevenine.lineup.business.rules.lineup.LineupValidationRules;
import com.sevenine.lineup.infrastructure.properties.ValidationLineupProperties;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@RequiredArgsConstructor
@Component
public class ValidFormation implements LineupValidationRules {

    private Lineup lineup;
    private final ValidationLineupProperties properties;

    @Override
    public void execute(Lineup lineup) {
        this.lineup = lineup;

        Arrays.stream(lineup.getFormationEnum().getAcronym().split("-")).forEach(formation -> {
            if (quantityPlayersPosition(formation.substring(0, 1)) != quantityFormation(formation.substring(1, 2))) {
                lineup.logAndThrow(properties.getFormation(), formation,
                        quantityPlayersPosition(formation.substring(0, 1)));
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
