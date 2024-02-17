package com.sevenine.lineup.application.usecase.output;

import java.time.LocalDateTime;

public record SaveLineupOutput(String uuidLineup, LocalDateTime dateTimeLineup, String message) {
}
