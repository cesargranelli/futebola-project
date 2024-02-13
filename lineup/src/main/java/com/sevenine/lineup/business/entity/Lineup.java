package com.sevenine.lineup.business.entity;

import com.sevenine.lineup.business.enumerated.FormationEnum;
import com.sevenine.lineup.infrastructure.exception.FormationException;
import com.sevenine.lineup.infrastructure.properties.ValidationLineupProperties;
import lombok.Getter;
import lombok.Setter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.List;

import static java.lang.String.format;

@Getter
@Setter
public class Lineup {
    private final Logger logger = LoggerFactory.getLogger(Lineup.class);

    private FormationEnum formationEnum;
    private String userUuid;
    private Integer roundNumber;
    private List<Player> players;
    private List<Player> reserves;
    private final Integer totalPlayers = 11;
    private final Integer totalReserves = 3;

    public void validQuantityPlayers(ValidationLineupProperties properties) {
        if (this.players.size() != this.totalPlayers) {
            logAndThrow(properties.getQuantityPlayers(), this.totalPlayers, "");
        }
        if (this.reserves.size() != this.totalReserves) {
            logAndThrow(properties.getQuantityReserves(), this.totalReserves, "");
        }
    }

    public void validFormation(ValidationLineupProperties properties) {
        Arrays.stream(this.getFormationEnum().getAcronym().split("-")).forEach(formation -> {
            if (quantityPlayersPosition(formation.substring(0, 1)) != quantityFormation(formation.substring(1, 2))) {
                logAndThrow(properties.getFormation(), formation,
                        quantityPlayersPosition(formation.substring(0, 1)));
            }
        });
    }

    private void logAndThrow(String message, Object... values) {
        logger.error(message.replaceAll("%s", "{}"), values[0], values[1]);

        throw new FormationException(format(message, values[0], values[1]));
    }

    private int quantityPlayersPosition(String position) {
        return this.players.stream().filter(player ->
                player.getPosition().getAcronym().equals(position)).toList().size();
    }

    private int quantityFormation(String position) {
        return Integer.parseInt(position);
    }
}
