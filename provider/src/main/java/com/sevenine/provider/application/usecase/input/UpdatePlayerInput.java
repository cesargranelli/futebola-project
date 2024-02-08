package com.sevenine.provider.application.usecase.input;

import com.sevenine.provider.business.enumerated.ProviderEnum;
import jakarta.validation.constraints.NotNull;

public record UpdatePlayerInput(@NotNull ProviderEnum provider) {
}
