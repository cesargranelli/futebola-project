package com.sevenine.provider.infrastructure.client.apidojo.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record TeamApiDojo(int id, String name, String slug, String shortName, String nameCode) {
}
