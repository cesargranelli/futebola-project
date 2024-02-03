package com.sevenine.sofascore.infrastructure.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Getter
@Setter
@ConfigurationProperties("rapidapi.sofascore")
public class RapidApiProperties {
    @Value("endpoints")
    private String getStadings;
    @Value("credentials")
    private String xRapidapiHost;
    @Value("credentials")
    private String xRapidapiKey;
}
