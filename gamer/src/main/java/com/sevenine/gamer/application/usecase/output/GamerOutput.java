package com.sevenine.gamer.application.usecase.output;

import com.sevenine.gamer.business.entity.League;

import java.math.BigDecimal;
import java.util.List;

public record GamerOutput(String uuid, String uuidUser, String nick, Integer points, TeamOutput team,
                          List<LeagueOutput> leagues, BigDecimal totalScore, BigDecimal roundScore,
                          String createAt) {
}
