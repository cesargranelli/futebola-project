package com.sevenine.lineup.infrastructure.client.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record GamerResponse(String uuid, String uuidUser, String nick, String points) {
}
