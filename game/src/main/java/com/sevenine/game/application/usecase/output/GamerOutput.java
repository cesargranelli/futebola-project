package com.sevenine.game.application.usecase.output;

import java.math.BigDecimal;
import java.util.List;

public record GamerOutput(String uuid, String uuidUser, String nick, Integer points, TeamOutput team,
                          List<LeagueOutput> leagues, BigDecimal totalScore, BigDecimal roundScore,
                          String createAt) {
}
