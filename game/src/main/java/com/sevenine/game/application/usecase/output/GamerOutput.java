package com.sevenine.game.application.usecase.output;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.math.BigDecimal;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record GamerOutput(String uuid, String uuidUser, String nick, Integer points, TeamOutput team,
                          List<LeagueOutput> leagues, BigDecimal totalScore, BigDecimal roundScore,
                          String createAt) {
}
