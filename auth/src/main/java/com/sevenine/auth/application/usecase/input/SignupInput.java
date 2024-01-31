package com.sevenine.auth.application.usecase.input;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record SignupInput(@NotEmpty String name, @NotNull LocalDate birthdate, @NotEmpty String email,
                          @NotEmpty String password) {
}
