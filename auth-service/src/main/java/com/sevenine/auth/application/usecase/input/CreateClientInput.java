package com.sevenine.auth.application.usecase.input;

import java.time.LocalDate;

public record CreateClientInput(String name, LocalDate birthdate, String document) {
}
