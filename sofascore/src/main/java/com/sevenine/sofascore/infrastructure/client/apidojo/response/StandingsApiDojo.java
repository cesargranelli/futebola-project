package com.sevenine.sofascore.infrastructure.client.apidojo.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record StandingsApiDojo(List<RowsApiDojo> rows) {
}
