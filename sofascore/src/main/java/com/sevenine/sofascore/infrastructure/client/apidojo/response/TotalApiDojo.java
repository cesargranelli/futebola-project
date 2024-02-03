package com.sevenine.sofascore.infrastructure.client.apidojo.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record TotalApiDojo(List<StandingsApiDojo> standings) {
}
