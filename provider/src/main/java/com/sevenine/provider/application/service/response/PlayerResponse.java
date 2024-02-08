package com.sevenine.provider.application.service.response;

public record PlayerResponse(long id, String name, String slug, String shortName, String position,
                             long shirtNumber, TeamResponse team) {
}
