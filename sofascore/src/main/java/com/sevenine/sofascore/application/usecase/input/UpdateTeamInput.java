package com.sevenine.sofascore.application.usecase.input;

import com.sevenine.sofascore.business.enumerated.ProviderEnum;
import com.sevenine.sofascore.business.enumerated.SeasonEnum;
import com.sevenine.sofascore.business.enumerated.TournamentEnum;
import jakarta.validation.constraints.NotNull;

public record UpdateTeamInput(@NotNull ProviderEnum provider, @NotNull TournamentEnum tournament,
                              @NotNull SeasonEnum season) {
}
