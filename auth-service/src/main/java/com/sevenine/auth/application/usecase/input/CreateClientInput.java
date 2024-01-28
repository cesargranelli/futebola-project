package com.sevenine.auth.client.application.usecase.input;

import java.time.LocalDate;

public record CreateClientInput(String name, LocalDate birthdate, String document) {
}
