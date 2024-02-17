package com.sevenine.lineup.application.usecase.input;

import jakarta.validation.constraints.NotEmpty;

public record GamerInput(@NotEmpty String uuid, @NotEmpty String uuidUser, @NotEmpty String nick) {
}
