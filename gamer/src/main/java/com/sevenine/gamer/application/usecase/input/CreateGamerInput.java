package com.sevenine.gamer.application.usecase.input;

import jakarta.validation.constraints.NotEmpty;

public record CreateGamerInput(@NotEmpty String uuidUser, @NotEmpty String nick) {
}
