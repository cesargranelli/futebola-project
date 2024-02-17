package com.sevenine.lineup.application.usecase.input;

import com.sevenine.lineup.business.enumerated.FormationEnum;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public record LineupInput(@NotNull GamerInput gamer, FormationEnum formationEnum, @NotNull int roundNumber,
                          @NotEmpty List<PlayerInput> players, @NotEmpty List<PlayerInput> reserves) {
}
