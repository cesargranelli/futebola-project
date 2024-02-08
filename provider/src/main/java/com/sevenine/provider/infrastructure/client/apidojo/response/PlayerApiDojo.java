package com.sevenine.provider.infrastructure.client.apidojo.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record PlayerApiDojo(long id, String name, String slug, String shortName, String position,
                            long shirtNumber, TeamApiDojo team) {
}
