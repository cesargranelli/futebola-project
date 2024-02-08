package com.sevenine.provider.infrastructure.client.apidojo.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record PlayersApiDojo(PlayerApiDojo player) {
}
