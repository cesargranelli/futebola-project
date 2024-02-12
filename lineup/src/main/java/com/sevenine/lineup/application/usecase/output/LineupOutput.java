package com.sevenine.lineup.application.usecase.output;

import java.time.LocalDateTime;

public record LineupOutput(String uuidLineup, LocalDateTime dateTimeLineup, String message) {
}
