package com.sevenine.provider.application.usecase.input;

import com.sevenine.provider.business.enumerated.ProviderEnum;
import com.sevenine.provider.business.enumerated.SeasonEnum;
import com.sevenine.provider.business.enumerated.TournamentEnum;
import jakarta.validation.constraints.NotNull;

public record UpdateTeamInput(@NotNull ProviderEnum provider, @NotNull TournamentEnum tournament,
                              @NotNull SeasonEnum season) {
}
