package com.sevenine.lineup.business.rules;

import com.sevenine.lineup.business.entity.Lineup;
import com.sevenine.lineup.business.entity.Player;
import com.sevenine.lineup.business.rules.lineup.LineupValidationRules;
import com.sevenine.lineup.infrastructure.properties.LineupErrorProperties;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

import java.util.List;

@ConditionalOnProperty(prefix = "app.rules", name = "validation-starting-players", havingValue = "true")
@RequiredArgsConstructor
@Component
public class ValidationStartingPlayers implements LineupValidationRules {

    private final LineupErrorProperties properties;

    @Override
    public void execute(Lineup lineup) {
        Integer points = Integer.sum(getPointsPlayers(lineup.getPlayers()), getPointsPlayers(lineup.getReserves()));

        if (points.compareTo(lineup.getGamer().getPoints()) > 0) {
            lineup.logAndThrow(properties.getPointsGamer(), points, lineup.getGamer().getPoints());
        }
    }

    private Integer getPointsPlayers(List<Player> players) {
        return players.stream().mapToInt(player -> player.getPoints().getTotalPoints()).sum();
    }

}
